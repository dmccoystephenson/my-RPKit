/*
 * This file is generated by jOOQ.
 */
package com.rpkit.essentials.bukkit.database.jooq.tables;


import com.rpkit.essentials.bukkit.database.jooq.Keys;
import com.rpkit.essentials.bukkit.database.jooq.RpkitEssentials;
import com.rpkit.essentials.bukkit.database.jooq.tables.records.RpkitLogMessagesEnabledRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row1;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitLogMessagesEnabled extends TableImpl<RpkitLogMessagesEnabledRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of
     * <code>rpkit_essentials.rpkit_log_messages_enabled</code>
     */
    public static final RpkitLogMessagesEnabled RPKIT_LOG_MESSAGES_ENABLED = new RpkitLogMessagesEnabled();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitLogMessagesEnabledRecord> getRecordType() {
        return RpkitLogMessagesEnabledRecord.class;
    }

    /**
     * The column
     * <code>rpkit_essentials.rpkit_log_messages_enabled.minecraft_profile_id</code>.
     */
    public final TableField<RpkitLogMessagesEnabledRecord, Integer> MINECRAFT_PROFILE_ID = createField(DSL.name("minecraft_profile_id"), SQLDataType.INTEGER.nullable(false), this, "");

    private RpkitLogMessagesEnabled(Name alias, Table<RpkitLogMessagesEnabledRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitLogMessagesEnabled(Name alias, Table<RpkitLogMessagesEnabledRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased
     * <code>rpkit_essentials.rpkit_log_messages_enabled</code> table reference
     */
    public RpkitLogMessagesEnabled(String alias) {
        this(DSL.name(alias), RPKIT_LOG_MESSAGES_ENABLED);
    }

    /**
     * Create an aliased
     * <code>rpkit_essentials.rpkit_log_messages_enabled</code> table reference
     */
    public RpkitLogMessagesEnabled(Name alias) {
        this(alias, RPKIT_LOG_MESSAGES_ENABLED);
    }

    /**
     * Create a <code>rpkit_essentials.rpkit_log_messages_enabled</code> table
     * reference
     */
    public RpkitLogMessagesEnabled() {
        this(DSL.name("rpkit_log_messages_enabled"), null);
    }

    public <O extends Record> RpkitLogMessagesEnabled(Table<O> child, ForeignKey<O, RpkitLogMessagesEnabledRecord> key) {
        super(child, key, RPKIT_LOG_MESSAGES_ENABLED);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : RpkitEssentials.RPKIT_ESSENTIALS;
    }

    @Override
    public UniqueKey<RpkitLogMessagesEnabledRecord> getPrimaryKey() {
        return Keys.KEY_RPKIT_LOG_MESSAGES_ENABLED_PRIMARY;
    }

    @Override
    public RpkitLogMessagesEnabled as(String alias) {
        return new RpkitLogMessagesEnabled(DSL.name(alias), this);
    }

    @Override
    public RpkitLogMessagesEnabled as(Name alias) {
        return new RpkitLogMessagesEnabled(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitLogMessagesEnabled rename(String name) {
        return new RpkitLogMessagesEnabled(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitLogMessagesEnabled rename(Name name) {
        return new RpkitLogMessagesEnabled(name, null);
    }

    // -------------------------------------------------------------------------
    // Row1 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row1<Integer> fieldsRow() {
        return (Row1) super.fieldsRow();
    }
}
