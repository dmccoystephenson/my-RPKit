/*
 * This file is generated by jOOQ.
 */
package com.rpkit.chat.bukkit.database.jooq;


import com.rpkit.chat.bukkit.database.jooq.tables.RpkitChatGroup;
import com.rpkit.chat.bukkit.database.jooq.tables.records.RpkitChatGroupRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * rpkit_chat.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<RpkitChatGroupRecord> KEY_RPKIT_CHAT_GROUP_PRIMARY = Internal.createUniqueKey(RpkitChatGroup.RPKIT_CHAT_GROUP, DSL.name("KEY_rpkit_chat_group_PRIMARY"), new TableField[] { RpkitChatGroup.RPKIT_CHAT_GROUP.ID }, true);
}
