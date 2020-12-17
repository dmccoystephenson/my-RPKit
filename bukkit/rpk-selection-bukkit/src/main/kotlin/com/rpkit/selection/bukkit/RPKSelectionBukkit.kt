/*
 * Copyright 2020 Ren Binden
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rpkit.selection.bukkit

import com.rpkit.core.bukkit.plugin.RPKBukkitPlugin
import com.rpkit.core.database.Database
import com.rpkit.core.database.DatabaseConnectionProperties
import com.rpkit.core.database.DatabaseMigrationProperties
import com.rpkit.core.database.UnsupportedDatabaseDialectException
import com.rpkit.core.service.Services
import com.rpkit.selection.bukkit.command.WandCommand
import com.rpkit.selection.bukkit.database.table.RPKSelectionTable
import com.rpkit.selection.bukkit.listener.PlayerInteractListener
import com.rpkit.selection.bukkit.selection.RPKSelectionService
import com.rpkit.selection.bukkit.selection.RPKSelectionServiceImpl
import org.bstats.bukkit.Metrics
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File


class RPKSelectionBukkit : RPKBukkitPlugin() {

    lateinit var database: Database

    override fun onEnable() {
        System.setProperty("com.rpkit.selection.bukkit.shadow.impl.org.jooq.no-logo", "true")

        Metrics(this, 4411)
        saveDefaultConfig()

        val databaseConfigFile = File(dataFolder, "database.yml")
        if (!databaseConfigFile.exists()) {
            saveResource("database.yml", false)
        }
        val databaseConfig = YamlConfiguration.loadConfiguration(databaseConfigFile)
        val databaseUrl = databaseConfig.getString("database.url")
        if (databaseUrl == null) {
            logger.severe("Database URL not set!")
            isEnabled = false
            return
        }
        val databaseUsername = databaseConfig.getString("database.username")
        val databasePassword = databaseConfig.getString("database.password")
        val databaseSqlDialect = databaseConfig.getString("database.dialect")
        val databaseMaximumPoolSize = databaseConfig.getInt("database.maximum-pool-size", 3)
        val databaseMinimumIdle = databaseConfig.getInt("database.minimum-idle", 3)
        if (databaseSqlDialect == null) {
            logger.severe("Database SQL dialect not set!")
            isEnabled = false
            return
        }
        database = Database(
                DatabaseConnectionProperties(
                        databaseUrl,
                        databaseUsername,
                        databasePassword,
                        databaseSqlDialect,
                        databaseMaximumPoolSize,
                        databaseMinimumIdle
                ),
                DatabaseMigrationProperties(
                        when (databaseSqlDialect) {
                            "MYSQL" -> "com/rpkit/selection/migrations/mysql"
                            "SQLITE" -> "com/rpkit/selection/migrations/sqlite"
                            else -> throw UnsupportedDatabaseDialectException("Unsupported database dialect $databaseSqlDialect")
                        },
                        "flyway_schema_history_selection"
                ),
                classLoader
        )
        database.addTable(RPKSelectionTable(database, this))

        Services[RPKSelectionService::class.java] = RPKSelectionServiceImpl(this)
    }

    override fun registerListeners() {
        registerListeners(
                PlayerInteractListener(this)
        )
    }

    override fun registerCommands() {
        getCommand("wand")?.setExecutor(WandCommand(this))
    }

    override fun setDefaultMessages() {
        messages.setDefault("not-from-console", "&cYou must be a player to perform that action.")
        messages.setDefault("wand-valid", "&fHere's a wand.")
        messages.setDefault("wand-primary", "&fFirst location set to &7\$world&f, &7\$x&f, &7\$y&f, &7\$z")
        messages.setDefault("wand-secondary", "&fSecond location set to &7\$world&f, &7\$x&f, &7\$y&f, &7\$z")
        messages.setDefault("no-permission-wand", "&cYou do not have permission to obtain a selection wand.")
        messages.setDefault("no-minecraft-profile-service", "&cThere is no Minecraft profile service available.")
        messages.setDefault("no-selection-service", "&cThere is no selection service available.")
    }

}