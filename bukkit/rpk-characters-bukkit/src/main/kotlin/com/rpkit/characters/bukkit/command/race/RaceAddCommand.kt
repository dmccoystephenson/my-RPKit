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

package com.rpkit.characters.bukkit.command.race

import com.rpkit.characters.bukkit.RPKCharactersBukkit
import com.rpkit.characters.bukkit.race.RPKRaceImpl
import com.rpkit.characters.bukkit.race.RPKRaceService
import com.rpkit.core.service.Services
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.conversations.*
import org.bukkit.entity.Player

/**
 * Race add command.
 * Adds a race.
 */
class RaceAddCommand(private val plugin: RPKCharactersBukkit) : CommandExecutor {
    private val conversationFactory: ConversationFactory

    init {
        conversationFactory = ConversationFactory(plugin)
                .withModality(true)
                .withFirstPrompt(RacePrompt())
                .withEscapeSequence("cancel")
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
        if (sender !is Conversable) return true
        if (!sender.hasPermission("rpkit.characters.command.race.add")) {
            sender.sendMessage(plugin.messages["no-permission-race-add"])
            return true
        }
        if (args.isEmpty()) {
            conversationFactory.buildConversation(sender).begin()
            return true
        }
        val raceService = Services[RPKRaceService::class.java]
        if (raceService == null) {
            sender.sendMessage(plugin.messages["no-race-service"])
            return true
        }
        val raceBuilder = StringBuilder()
        for (i in 0 until args.size - 1) {
            raceBuilder.append(args[i]).append(' ')
        }
        raceBuilder.append(args[args.size - 1])
        if (raceService.getRace(raceBuilder.toString()) != null) {
            sender.sendMessage(plugin.messages["race-add-invalid-race"])
            return true
        }
        raceService.addRace(RPKRaceImpl(name = raceBuilder.toString()))
        sender.sendMessage(plugin.messages["race-add-valid"])
        return true
    }

    private inner class RacePrompt : ValidatingPrompt() {

        override fun getPromptText(context: ConversationContext): String {
            return plugin.messages["race-add-prompt"]
        }

        override fun isInputValid(context: ConversationContext, input: String): Boolean {
            val raceService = Services[RPKRaceService::class.java] ?: return false
            return raceService.getRace(input) == null
        }

        override fun acceptValidatedInput(context: ConversationContext, input: String): Prompt {
            val raceService = Services[RPKRaceService::class.java] ?: return RaceAddedPrompt()
            raceService.addRace(RPKRaceImpl(name = input))
            return RaceAddedPrompt()
        }

        override fun getFailedValidationText(context: ConversationContext, invalidInput: String): String {
            return plugin.messages["race-add-invalid-race"]
        }

    }

    private inner class RaceAddedPrompt : MessagePrompt() {

        override fun getNextPrompt(context: ConversationContext): Prompt? {
            return Prompt.END_OF_CONVERSATION
        }

        override fun getPromptText(context: ConversationContext): String {
            if (Services[RPKRaceService::class.java] == null) return plugin.messages["no-race-service"]
            return plugin.messages["race-add-valid"]
        }

    }

}
