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

package com.rpkit.characters.bukkit.command.character.delete

import com.rpkit.characters.bukkit.RPKCharactersBukkit
import com.rpkit.characters.bukkit.character.RPKCharacterProvider
import com.rpkit.players.bukkit.player.RPKPlayerProvider
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.conversations.*
import org.bukkit.entity.Player

/**
 * Character delete command.
 * Deletes a character.
 */
class CharacterDeleteCommand(private val plugin: RPKCharactersBukkit): CommandExecutor {
    private val conversationFactory: ConversationFactory
    private val confirmationConversationFactory: ConversationFactory

    init {
        conversationFactory = ConversationFactory(plugin)
                .withModality(true)
                .withFirstPrompt(CharacterPrompt())
                .withEscapeSequence("cancel")
                .thatExcludesNonPlayersWithMessage(plugin.messages["not-from-console"])
                .addConversationAbandonedListener { event ->
            if (!event.gracefulExit()) {
                val conversable = event.context.forWhom
                if (conversable is Player) {
                    conversable.sendMessage(plugin.messages["operation-cancelled"])
                }
            }
        }
        confirmationConversationFactory = ConversationFactory(plugin)
                .withModality(true)
                .withFirstPrompt(ConfirmationPrompt())
                .withEscapeSequence("cancel")
                .thatExcludesNonPlayersWithMessage(plugin.messages["not-from-console"])
                .addConversationAbandonedListener { event ->
            if (!event.gracefulExit()) {
                val conversable = event.context.forWhom
                if (conversable is Player) {
                    conversable.sendMessage(plugin.messages["operation-cancelled"])
                }
            }
        }
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (sender is Player) {
            if (sender.hasPermission("rpkit.characters.command.character.delete")) {
                if (args.isNotEmpty()) {
                    val characterNameBuilder = StringBuilder()
                    for (i in 0..args.size - 1 - 1) {
                        characterNameBuilder.append(args[i]).append(" ")
                    }
                    characterNameBuilder.append(args[args.size - 1])
                    val characterProvider = plugin.core.serviceManager.getServiceProvider(RPKCharacterProvider::class)
                    val playerProvider = plugin.core.serviceManager.getServiceProvider(RPKPlayerProvider::class)
                    val player = playerProvider.getPlayer(sender)
                    var charFound = false
                    // Prioritise exact matches...
                    for (character in characterProvider.getCharacters(player)) {
                        if (character.name.equals(characterNameBuilder.toString(), ignoreCase = true)) {
                            val conversation = confirmationConversationFactory.buildConversation(sender)
                            conversation.context.setSessionData("character_id", character.id)
                            conversation.begin()
                            charFound = true
                            break
                        }
                    }
                    // And fall back to partial matches
                    if (!charFound) {
                        for (character in characterProvider.getCharacters(player)) {
                            if (character.name.toLowerCase().contains(characterNameBuilder.toString().toLowerCase())) {
                                val conversation = confirmationConversationFactory.buildConversation(sender)
                                conversation.context.setSessionData("character_id", character.id)
                                conversation.begin()
                                charFound = true
                                break
                            }
                        }
                    }
                    if (charFound) {
                        sender.sendMessage(plugin.messages["character-delete-valid"])
                    } else {
                        sender.sendMessage(plugin.messages["character-delete-invalid-character"])
                    }
                } else {
                    conversationFactory.buildConversation(sender).begin()
                }
            } else {
                sender.sendMessage(plugin.messages["no-permission-character-delete"])
            }
        } else {
            sender.sendMessage(plugin.messages["not-from-console"])
        }
        return true
    }

    private inner class CharacterPrompt: ValidatingPrompt() {

        override fun isInputValid(context: ConversationContext, input: String): Boolean {
            val conversable = context.forWhom
            if (conversable is Player) {
                val characterProvider = plugin.core.serviceManager.getServiceProvider(RPKCharacterProvider::class)
                val playerProvider = plugin.core.serviceManager.getServiceProvider(RPKPlayerProvider::class)
                val player = playerProvider.getPlayer(conversable)
                for (character in characterProvider.getCharacters(player)) {
                    if (character.name.equals(input, ignoreCase = true)) {
                        return true
                    }
                }
                for (character in characterProvider.getCharacters(player)) {
                    if (character.name.toLowerCase().contains(input.toLowerCase())) {
                        return true
                    }
                }
            }
            return false
        }

        override fun acceptValidatedInput(context: ConversationContext, input: String): Prompt {
            val conversable = context.forWhom
            if (conversable is Player) {
                val characterProvider = plugin.core.serviceManager.getServiceProvider(RPKCharacterProvider::class)
                val playerProvider = plugin.core.serviceManager.getServiceProvider(RPKPlayerProvider::class)
                val player = playerProvider.getPlayer(conversable)
                var charFound = false
                // Prioritise exact matches...
                for (character in characterProvider.getCharacters(player)) {
                    if (character.name.equals(input, ignoreCase = true)) {
                        context.setSessionData("character_id", character.id)
                        charFound = true
                        break
                    }
                }
                // And fall back to partial matches
                if (!charFound) {
                    for (character in characterProvider.getCharacters(player)) {
                        if (character.name.toLowerCase().contains(input.toLowerCase())) {
                            context.setSessionData("character_id", character.id)
                            break
                        }
                    }
                }
            }
            return CharacterDeletedPrompt()
        }

        override fun getFailedValidationText(context: ConversationContext?, invalidInput: String?): String {
            return plugin.messages["character-delete-invalid-character"]
        }

        override fun getPromptText(context: ConversationContext): String {
            val playerProvider = plugin.core.serviceManager.getServiceProvider(RPKPlayerProvider::class)
            val player = playerProvider.getPlayer(context.forWhom as Player)
            val characterProvider = plugin.core.serviceManager.getServiceProvider(RPKCharacterProvider::class)
            val characterListBuilder = StringBuilder()
            for (character in characterProvider.getCharacters(player)) {
                characterListBuilder.append("\n").append(
                        plugin.messages["character-list-item", mapOf(
                                Pair("character", character.name))]
                )
            }
            return plugin.messages["character-delete-prompt"] + characterListBuilder.toString()
        }

    }

    private inner class ConfirmationPrompt: BooleanPrompt() {

        override fun acceptValidatedInput(context: ConversationContext, input: Boolean): Prompt? {
            if (input) {
                val characterProvider = plugin.core.serviceManager.getServiceProvider(RPKCharacterProvider::class)
                val character = characterProvider.getCharacter(context.getSessionData("character_id") as Int)
                characterProvider.removeCharacter(character!!)
                return CharacterDeletedPrompt()
            } else {
                return Prompt.END_OF_CONVERSATION
            }
        }

        override fun getFailedValidationText(context: ConversationContext?, invalidInput: String?): String {
            return plugin.messages["character-delete-confirmation-invalid-boolean"]
        }

        override fun getPromptText(context: ConversationContext): String {
            return plugin.messages["character-delete-confirmation"]
        }

    }

    private inner class CharacterDeletedPrompt: MessagePrompt() {

        override fun getNextPrompt(context: ConversationContext): Prompt? {
            return Prompt.END_OF_CONVERSATION
        }

        override fun getPromptText(context: ConversationContext): String {
            return plugin.messages["character-delete-valid"]
        }
    }

}
