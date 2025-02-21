/*
 * This file is generated by jOOQ.
 */
package com.rpkit.chat.bukkit.database.jooq;


import com.rpkit.chat.bukkit.database.jooq.tables.RpkitChatChannelMute;
import com.rpkit.chat.bukkit.database.jooq.tables.RpkitChatChannelSpeaker;
import com.rpkit.chat.bukkit.database.jooq.tables.RpkitChatGroup;
import com.rpkit.chat.bukkit.database.jooq.tables.RpkitChatGroupInvite;
import com.rpkit.chat.bukkit.database.jooq.tables.RpkitChatGroupMember;
import com.rpkit.chat.bukkit.database.jooq.tables.RpkitChatNameColor;
import com.rpkit.chat.bukkit.database.jooq.tables.RpkitLastUsedChatGroup;
import com.rpkit.chat.bukkit.database.jooq.tables.RpkitSnooper;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitChat extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>rpkit_chat</code>
     */
    public static final RpkitChat RPKIT_CHAT = new RpkitChat();

    /**
     * The table <code>rpkit_chat.rpkit_chat_channel_mute</code>.
     */
    public final RpkitChatChannelMute RPKIT_CHAT_CHANNEL_MUTE = RpkitChatChannelMute.RPKIT_CHAT_CHANNEL_MUTE;

    /**
     * The table <code>rpkit_chat.rpkit_chat_channel_speaker</code>.
     */
    public final RpkitChatChannelSpeaker RPKIT_CHAT_CHANNEL_SPEAKER = RpkitChatChannelSpeaker.RPKIT_CHAT_CHANNEL_SPEAKER;

    /**
     * The table <code>rpkit_chat.rpkit_chat_group</code>.
     */
    public final RpkitChatGroup RPKIT_CHAT_GROUP = RpkitChatGroup.RPKIT_CHAT_GROUP;

    /**
     * The table <code>rpkit_chat.rpkit_chat_group_invite</code>.
     */
    public final RpkitChatGroupInvite RPKIT_CHAT_GROUP_INVITE = RpkitChatGroupInvite.RPKIT_CHAT_GROUP_INVITE;

    /**
     * The table <code>rpkit_chat.rpkit_chat_group_member</code>.
     */
    public final RpkitChatGroupMember RPKIT_CHAT_GROUP_MEMBER = RpkitChatGroupMember.RPKIT_CHAT_GROUP_MEMBER;

    /**
     * The table <code>rpkit_chat.rpkit_last_used_chat_group</code>.
     */
    public final RpkitLastUsedChatGroup RPKIT_LAST_USED_CHAT_GROUP = RpkitLastUsedChatGroup.RPKIT_LAST_USED_CHAT_GROUP;

    /**
     * The table <code>rpkit_chat.rpkit_snooper</code>.
     */
    public final RpkitSnooper RPKIT_SNOOPER = RpkitSnooper.RPKIT_SNOOPER;

    /**
     * The table <code>rpkit_chat.rpkit_chat_name_color</code>.
     */
    public final RpkitChatNameColor RPKIT_CHAT_NAME_COLOR = RpkitChatNameColor.RPKIT_CHAT_NAME_COLOR;

    /**
     * No further instances allowed
     */
    private RpkitChat() {
        super("rpkit_chat", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            RpkitChatChannelMute.RPKIT_CHAT_CHANNEL_MUTE,
            RpkitChatChannelSpeaker.RPKIT_CHAT_CHANNEL_SPEAKER,
            RpkitChatGroup.RPKIT_CHAT_GROUP,
            RpkitChatGroupInvite.RPKIT_CHAT_GROUP_INVITE,
            RpkitChatGroupMember.RPKIT_CHAT_GROUP_MEMBER,
            RpkitLastUsedChatGroup.RPKIT_LAST_USED_CHAT_GROUP,
            RpkitSnooper.RPKIT_SNOOPER,
            RpkitChatNameColor.RPKIT_CHAT_NAME_COLOR
        );
    }
}
