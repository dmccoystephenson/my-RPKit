package com.rpkit.travel.bukkit

import com.rpkit.core.bukkit.plugin.RPKBukkitPlugin
import com.rpkit.core.database.Database
import com.rpkit.travel.bukkit.command.DeleteWarpCommand
import com.rpkit.travel.bukkit.command.SetWarpCommand
import com.rpkit.travel.bukkit.command.WarpCommand
import com.rpkit.travel.bukkit.database.table.RPKWarpTable
import com.rpkit.travel.bukkit.listener.PlayerInteractListener
import com.rpkit.travel.bukkit.listener.SignChangeListener
import com.rpkit.travel.bukkit.warp.RPKWarpProviderImpl


class RPKTravelBukkit: RPKBukkitPlugin() {

    override fun onEnable() {
        serviceProviders = arrayOf(
                RPKWarpProviderImpl(this)
        )
    }

    override fun registerListeners() {
        registerListeners(
                PlayerInteractListener(this),
                SignChangeListener(this)
        )
    }

    override fun registerCommands() {
        getCommand("deletewarp").executor = DeleteWarpCommand(this)
        getCommand("setwarp").executor = SetWarpCommand(this)
        getCommand("warp").executor = WarpCommand(this)
    }

    override fun createTables(database: Database) {
        database.addTable(RPKWarpTable(database, this))
    }

    override fun setDefaultMessages() {
        core.messages.setDefault("warp-sign-invalid-warp", "&cThere is no warp by that name.")
        core.messages.setDefault("warp-sign-valid", "&aWarp sign created.")
        core.messages.setDefault("no-permission-warp-sign-create", "&cYou do not have permission to create warp signs.")
    }

}