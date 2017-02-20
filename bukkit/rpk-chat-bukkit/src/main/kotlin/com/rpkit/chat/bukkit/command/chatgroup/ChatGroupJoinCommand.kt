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

package com.rpkit.chat.bukkit.command.chatgroup

import com.rpkit.chat.bukkit.RPKChatBukkit
import com.rpkit.chat.bukkit.chatgroup.RPKChatGroupProvider
import com.rpkit.players.bukkit.player.RPKPlayerProvider
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

/**
 * Chat group join command.
 * Joins a chat group.
 */
class ChatGroupJoinCommand(private val plugin: RPKChatBukkit): CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender.hasPermission("rpkit.chat.command.chatgroup.join")) {
            if (args.isNotEmpty()) {
                val playerProvider = plugin.core.serviceManager.getServiceProvider(RPKPlayerProvider::class)
                val chatGroupProvider = plugin.core.serviceManager.getServiceProvider(RPKChatGroupProvider::class)
                val chatGroup = chatGroupProvider.getChatGroup(args[0])
                if (chatGroup != null) {
                    if (sender is Player) {
                        val player = playerProvider.getPlayer(sender)
                        if (chatGroup.invited.contains(player)) {
                            chatGroup.members.forEach { member -> member.bukkitPlayer?.player?.sendMessage(plugin.messages["chat-group-join-received", mapOf(
                                    Pair("group", chatGroup.name),
                                    Pair("player", player.name)
                            )]) }
                            chatGroup.addMember(player)
                            chatGroup.uninvite(player)
                            sender.sendMessage(plugin.messages["chat-group-join-valid", mapOf(
                                    Pair("group", chatGroup.name)
                            )])
                        } else {
                            sender.sendMessage(plugin.messages["chat-group-join-invalid-no-invite"])
                        }
                    } else {
                        sender.sendMessage(plugin.messages["not-from-console"])
                    }
                } else {
                    sender.sendMessage(plugin.messages["chat-group-join-invalid-chat-group"])
                }
            } else {
                sender.sendMessage(plugin.messages["chat-group-join-usage"])
            }
        } else {
            sender.sendMessage(plugin.messages["no-permission-chat-group-join"])
        }
        return true
    }

}