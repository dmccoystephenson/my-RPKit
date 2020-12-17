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

package com.rpkit.shops.bukkit

import com.rpkit.core.bukkit.plugin.RPKBukkitPlugin
import com.rpkit.core.database.Database
import com.rpkit.core.database.DatabaseConnectionProperties
import com.rpkit.core.database.DatabaseMigrationProperties
import com.rpkit.core.database.UnsupportedDatabaseDialectException
import com.rpkit.core.service.Services
import com.rpkit.shops.bukkit.command.RestockCommand
import com.rpkit.shops.bukkit.database.table.RPKShopCountTable
import com.rpkit.shops.bukkit.listener.BlockBreakListener
import com.rpkit.shops.bukkit.listener.InventoryClickListener
import com.rpkit.shops.bukkit.listener.PlayerInteractListener
import com.rpkit.shops.bukkit.listener.SignChangeListener
import com.rpkit.shops.bukkit.shopcount.RPKShopCountService
import com.rpkit.shops.bukkit.shopcount.RPKShopCountServiceImpl
import org.bstats.bukkit.Metrics
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

/**
 * RPK shops plugin default implementation.
 */
class RPKShopsBukkit : RPKBukkitPlugin() {

    lateinit var database: Database

    override fun onEnable() {
        System.setProperty("com.rpkit.shops.bukkit.shadow.impl.org.jooq.no-logo", "true")

        Metrics(this, 4415)
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
                            "MYSQL" -> "com/rpkit/shops/migrations/mysql"
                            "SQLITE" -> "com/rpkit/shops/migrations/sqlite"
                            else -> throw UnsupportedDatabaseDialectException("Unsupported database dialect $databaseSqlDialect")
                        },
                        "flyway_schema_history_shops"
                ),
                classLoader
        )
        database.addTable(RPKShopCountTable(database, this))

        Services[RPKShopCountService::class.java] = RPKShopCountServiceImpl(this)
    }

    override fun registerListeners() {
        registerListeners(
                SignChangeListener(this),
                BlockBreakListener(this),
                PlayerInteractListener(this),
                InventoryClickListener(this)
        )
    }

    override fun registerCommands() {
        getCommand("restock")?.setExecutor(RestockCommand(this))
    }

    override fun setDefaultMessages() {
        messages.setDefault("restock-valid", "&aShop restocked.")
        messages.setDefault("restock-invalid-material", "&cThere is no material by that name.")
        messages.setDefault("restock-invalid-chest", "&cYou must be looking at a chest.")
        messages.setDefault("restock-usage", "&cUsage: /restock [material]")
        messages.setDefault("shop-line-1-invalid", "&cLine 1 format must be \"buy [number]\" or \"sell [number] [type]\"")
        messages.setDefault("shop-line-2-invalid", "&cLine 2 format must be \"for [price] [currency]\"")
        messages.setDefault("rent-line-2-invalid", "&cLine 2 format must be \"[cost] [currency]\"")
        messages.setDefault("rent-paid", "&aPaid for the next day of rent.")
        messages.setDefault("rent-ended", "&cThe lease on this shop has ended.")
        messages.setDefault("rent-invalid-currency", "&cRent is being charged in an invalid currency. Please get the owner to fix it.")
        messages.setDefault("rent-invalid-character", "&cThe character who is charging rent no longer exists.")
        messages.setDefault("rent-not-owner", "&cYou cannot pay rent for a shop you do not own.")
        messages.setDefault("rent-no-shop", "&cYou must create a shop before attempting to pay rent.")
        messages.setDefault("no-permission-shop", "&cYou do not have permission to create shops.")
        messages.setDefault("no-permission-shop-limit", "&cYou have surpassed the shop limit.")
        messages.setDefault("no-permission-shop-admin", "&cYou do not have permission to create admin shops.")
        messages.setDefault("no-permission-restock", "&cYou do not have permission to restock chests")
        messages.setDefault("no-permission-rent", "&cYou do not have permission to charge rent for shops.")
        messages.setDefault("no-character", "&cYou need a character in order to perform this action.")
        messages.setDefault("no-stealing", "&cYou cannot steal from this shop.")
        messages.setDefault("not-enough-money", "&cYou do not have enough money to buy that.")
        messages.setDefault("not-enough-shop-items", "&cThe shop does not contain enough items.")
        messages.setDefault("shop-sell-not-enough-money", "&cThe shop's owner does not have enough money to pay you.")
        messages.setDefault("shop-sell-chest-not-found", "&cCould not find a chest below that shop to place your item into.")
        messages.setDefault("shop-sell-not-enough-items", "&cYou do not have enough items to sell to that shop.")
        messages.setDefault("shop-character-invalid", "&cThere is no character with that ID. Perhaps they have been deleted?")
        messages.setDefault("shop-currency-invalid", "&cThere is no currency by that name.")
        messages.setDefault("shop-material-invalid", "&cThere is no material by that name.")
        messages.setDefault("trader-material-invalid", "&cThere is no material by that name.")
        messages.setDefault("not-from-console", "&cYou must be a player to perform that command.")
        messages.setDefault("no-minecraft-profile", "&cA Minecraft profile has not been created for you, or was unable to be retrieved. Please try relogging, and contact the server owner if this error persists.")
        messages.setDefault("no-minecraft-profile-service", "&cThere is no Minecraft profile service available.")
        messages.setDefault("no-character-service", "&cThere is no character service available.")
        messages.setDefault("no-economy-service", "&cThere is no economy service available.")
        messages.setDefault("no-bank-service", "&cThere is no bank service available.")
        messages.setDefault("no-shop-count-service", "&cThere is no shop count service available.")
    }

}