/*
 * Copyright 2016 Ross Binden
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

package com.rpkit.characters.bukkit.command.character.unhide

import com.rpkit.characters.bukkit.RPKCharactersBukkit
import com.rpkit.characters.bukkit.character.RPKCharacterProvider
import com.rpkit.players.bukkit.player.RPKPlayerProvider
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

/**
 * Character unhide description command.
 * Unhides character's description.
 */
class CharacterUnhideDescriptionCommand(private val plugin: RPKCharactersBukkit): CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player) {
            if (sender.hasPermission("rpkit.characters.command.character.unhide.description")) {
                val playerProvider = plugin.core.serviceManager.getServiceProvider(RPKPlayerProvider::class)
                val characterProvider = plugin.core.serviceManager.getServiceProvider(RPKCharacterProvider::class)
                val player = playerProvider.getPlayer(sender)
                val character = characterProvider.getActiveCharacter(player)
                if (character != null) {
                    character.isDescriptionHidden = false
                    characterProvider.updateCharacter(character)
                    sender.sendMessage(plugin.core.messages["character-unhide-description-valid"])
                    character.showCharacterCard(player)
                } else {
                    sender.sendMessage(plugin.core.messages["no-character"])
                }
            } else {
                sender.sendMessage(plugin.core.messages["no-permission-character-unhide-description"])
            }
        } else {
            sender.sendMessage(plugin.core.messages["not-from-console"])
        }
        return true
    }

}