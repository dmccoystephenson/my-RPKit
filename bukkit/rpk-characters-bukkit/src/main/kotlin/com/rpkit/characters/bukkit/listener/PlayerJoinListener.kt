/*
 * Copyright 2022 Ren Binden
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

package com.rpkit.characters.bukkit.listener

import com.rpkit.characters.bukkit.RPKCharactersBukkit
import com.rpkit.characters.bukkit.character.RPKCharacterService
import com.rpkit.characters.bukkit.protocol.reloadPlayer
import com.rpkit.core.service.Services
import com.rpkit.players.bukkit.profile.minecraft.RPKMinecraftProfileService
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

/**
 * Player join listener for display names.
 * Updates player display names upon joining in order to allow for chat plugins that do not have built-in RPK
 * support to utilise character names.
 */
class PlayerJoinListener(val plugin: RPKCharactersBukkit) : Listener {

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        setPlayerDisplayName(event)
        setPlayerNameplate(event)
        showOtherPlayerNameplates(event)
    }

    private fun setPlayerDisplayName(event: PlayerJoinEvent) {
        if (!plugin.config.getBoolean("characters.set-player-display-name")) return
        val minecraftProfileService = Services[RPKMinecraftProfileService::class.java] ?: return
        val characterService = Services[RPKCharacterService::class.java] ?: return
        val minecraftProfile = minecraftProfileService.getPreloadedMinecraftProfile(event.player) ?: return
        val character = characterService.getPreloadedActiveCharacter(minecraftProfile)
        if (character == null) {
            characterService.loadActiveCharacter(minecraftProfile).thenAccept { loadedCharacter ->
                plugin.server.scheduler.runTask(plugin, Runnable {
                    event.player.setDisplayName(loadedCharacter?.name ?: event.player.name)
                })
            }
        } else {
            event.player.setDisplayName(character.name)
        }
    }

    private fun setPlayerNameplate(event: PlayerJoinEvent) {
        if (!plugin.config.getBoolean("characters.set-player-nameplate") || plugin.server.pluginManager.getPlugin("ProtocolLib") == null) return
        val minecraftProfileService = Services[RPKMinecraftProfileService::class.java] ?: return
        val characterService = Services[RPKCharacterService::class.java] ?: return
        val minecraftProfile = minecraftProfileService.getPreloadedMinecraftProfile(event.player) ?: return
        val character = characterService.getPreloadedActiveCharacter(minecraftProfile)
        if (character == null) {
            characterService.loadActiveCharacter(minecraftProfile).thenAccept { loadedCharacter ->
                plugin.server.scheduler.scheduleSyncDelayedTask(plugin) {
                    if (loadedCharacter != null) {
                        reloadPlayer(event.player, loadedCharacter, plugin.server.onlinePlayers.filter { it.uniqueId != event.player.uniqueId })
                    }
                }
            }
        } else {
            plugin.server.scheduler.scheduleSyncDelayedTask(plugin) {
                reloadPlayer(event.player, character, plugin.server.onlinePlayers.filter { it.uniqueId != event.player.uniqueId })
            }
        }
    }

    private fun showOtherPlayerNameplates(event: PlayerJoinEvent) {
        if (!plugin.config.getBoolean("characters.set-player-nameplate") || plugin.server.pluginManager.getPlugin("ProtocolLib") == null) return
        plugin.server.scheduler.scheduleSyncDelayedTask(plugin) {
            val minecraftProfileService = Services[RPKMinecraftProfileService::class.java] ?: return@scheduleSyncDelayedTask
            val characterService = Services[RPKCharacterService::class.java] ?: return@scheduleSyncDelayedTask
            plugin.server.onlinePlayers.filter { it.uniqueId != event.player.uniqueId }.forEach { onlinePlayer ->
                val minecraftProfile =
                    minecraftProfileService.getPreloadedMinecraftProfile(onlinePlayer) ?: return@forEach
                val character = characterService.getPreloadedActiveCharacter(minecraftProfile) ?: return@forEach
                reloadPlayer(onlinePlayer, character, listOf(event.player))
            }
        }
    }

}