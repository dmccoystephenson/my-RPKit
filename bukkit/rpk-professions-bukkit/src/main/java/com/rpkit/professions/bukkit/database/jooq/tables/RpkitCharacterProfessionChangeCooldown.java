/*
 * This file is generated by jOOQ.
 */
package com.rpkit.professions.bukkit.database.jooq.tables;


import com.rpkit.professions.bukkit.database.jooq.Keys;
import com.rpkit.professions.bukkit.database.jooq.RpkitProfessions;
import com.rpkit.professions.bukkit.database.jooq.tables.records.RpkitCharacterProfessionChangeCooldownRecord;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
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
public class RpkitCharacterProfessionChangeCooldown extends TableImpl<RpkitCharacterProfessionChangeCooldownRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of
     * <code>rpkit_professions.rpkit_character_profession_change_cooldown</code>
     */
    public static final RpkitCharacterProfessionChangeCooldown RPKIT_CHARACTER_PROFESSION_CHANGE_COOLDOWN = new RpkitCharacterProfessionChangeCooldown();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitCharacterProfessionChangeCooldownRecord> getRecordType() {
        return RpkitCharacterProfessionChangeCooldownRecord.class;
    }

    /**
     * The column
     * <code>rpkit_professions.rpkit_character_profession_change_cooldown.character_id</code>.
     */
    public final TableField<RpkitCharacterProfessionChangeCooldownRecord, Integer> CHARACTER_ID = createField(DSL.name("character_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column
     * <code>rpkit_professions.rpkit_character_profession_change_cooldown.cooldown_end_time</code>.
     */
    public final TableField<RpkitCharacterProfessionChangeCooldownRecord, LocalDateTime> COOLDOWN_END_TIME = createField(DSL.name("cooldown_end_time"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field("current_timestamp()", SQLDataType.LOCALDATETIME)), this, "");

    private RpkitCharacterProfessionChangeCooldown(Name alias, Table<RpkitCharacterProfessionChangeCooldownRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitCharacterProfessionChangeCooldown(Name alias, Table<RpkitCharacterProfessionChangeCooldownRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased
     * <code>rpkit_professions.rpkit_character_profession_change_cooldown</code>
     * table reference
     */
    public RpkitCharacterProfessionChangeCooldown(String alias) {
        this(DSL.name(alias), RPKIT_CHARACTER_PROFESSION_CHANGE_COOLDOWN);
    }

    /**
     * Create an aliased
     * <code>rpkit_professions.rpkit_character_profession_change_cooldown</code>
     * table reference
     */
    public RpkitCharacterProfessionChangeCooldown(Name alias) {
        this(alias, RPKIT_CHARACTER_PROFESSION_CHANGE_COOLDOWN);
    }

    /**
     * Create a
     * <code>rpkit_professions.rpkit_character_profession_change_cooldown</code>
     * table reference
     */
    public RpkitCharacterProfessionChangeCooldown() {
        this(DSL.name("rpkit_character_profession_change_cooldown"), null);
    }

    public <O extends Record> RpkitCharacterProfessionChangeCooldown(Table<O> child, ForeignKey<O, RpkitCharacterProfessionChangeCooldownRecord> key) {
        super(child, key, RPKIT_CHARACTER_PROFESSION_CHANGE_COOLDOWN);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : RpkitProfessions.RPKIT_PROFESSIONS;
    }

    @Override
    public UniqueKey<RpkitCharacterProfessionChangeCooldownRecord> getPrimaryKey() {
        return Keys.KEY_RPKIT_CHARACTER_PROFESSION_CHANGE_COOLDOWN_PRIMARY;
    }

    @Override
    public RpkitCharacterProfessionChangeCooldown as(String alias) {
        return new RpkitCharacterProfessionChangeCooldown(DSL.name(alias), this);
    }

    @Override
    public RpkitCharacterProfessionChangeCooldown as(Name alias) {
        return new RpkitCharacterProfessionChangeCooldown(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitCharacterProfessionChangeCooldown rename(String name) {
        return new RpkitCharacterProfessionChangeCooldown(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitCharacterProfessionChangeCooldown rename(Name name) {
        return new RpkitCharacterProfessionChangeCooldown(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, LocalDateTime> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
