package com.rpkit.essentials.bukkit.command

import com.rpkit.essentials.bukkit.RPKEssentialsBukkit
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player

class EnchantCommand(private val plugin: RPKEssentialsBukkit) : CommandExecutor {

    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<String>): Boolean {
        if (sender.hasPermission("rpkit.essentials.command.enchant")) {
            if (sender is Player) {
                if (sender.inventory.itemInMainHand != null && sender.inventory.itemInMainHand.type != Material.AIR) {
                    if (args.size >= 2) {
                        if (sender.hasPermission("rpkit.essentials.command.enchant.unsafe")) {
                            val enchantment = Enchantment.getByName(args[0].toUpperCase())
                            if (enchantment != null) {
                                try {
                                    val level = args[1].toInt()
                                    sender.inventory.itemInMainHand.addUnsafeEnchantment(enchantment, level)
                                    sender.sendMessage(plugin.messages["enchant-valid", mapOf(
                                            Pair("amount", sender.inventory.itemInMainHand.amount.toString()),
                                            Pair("type", sender.inventory.itemInMainHand.type.toString().toLowerCase().replace('_', ' ')),
                                            Pair("enchantment", enchantment.name),
                                            Pair("level", level.toString())
                                    )])
                                } catch (exception: NumberFormatException) {
                                    sender.sendMessage(plugin.messages["enchant-invalid-level"])
                                }
                            } else {
                                sender.sendMessage(plugin.messages["enchant-invalid-enchantment"])
                            }
                        } else {
                            val enchantment = Enchantment.getByName(args[0].toUpperCase())
                            if (enchantment != null) {
                                try {
                                    val level = args[1].toInt()
                                    sender.inventory.itemInMainHand.addEnchantment(Enchantment.getByName(args[0].toUpperCase()), Integer.parseInt(args[1]))
                                    sender.sendMessage(plugin.messages["enchant-valid", mapOf(
                                            Pair("amount", sender.inventory.itemInMainHand.amount.toString()),
                                            Pair("type", sender.inventory.itemInMainHand.type.toString().toLowerCase().replace('_', ' ')),
                                            Pair("enchantment", enchantment.name),
                                            Pair("level", level.toString())
                                    )])
                                } catch (exception: NumberFormatException) {
                                    sender.sendMessage(plugin.messages["enchant-invalid-level"])
                                } catch (exception: IllegalArgumentException) {
                                    sender.sendMessage(plugin.messages["enchant-invalid-illegal"])
                                }
                            } else {
                                sender.sendMessage(plugin.messages["enchant-invalid-enchantment"])
                            }
                        }
                    } else {
                        sender.sendMessage(plugin.messages["enchant-usage"])
                    }
                } else {
                    sender.sendMessage(plugin.messages["enchant-invalid-item"])
                }
            } else {
                sender.sendMessage(plugin.messages["not-from-console"])
            }
        } else {
            sender.sendMessage(plugin.messages["no-permission-enchant"])
        }
        return true
    }

}
