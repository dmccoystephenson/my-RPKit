/*
 * This file is generated by jOOQ.
 */
package com.rpkit.store.bukkit.database.jooq.tables;


import com.rpkit.store.bukkit.database.jooq.Keys;
import com.rpkit.store.bukkit.database.jooq.RpkitStores;
import com.rpkit.store.bukkit.database.jooq.tables.records.RpkitStoreItemRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
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
public class RpkitStoreItem extends TableImpl<RpkitStoreItemRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>rpkit_stores.rpkit_store_item</code>
     */
    public static final RpkitStoreItem RPKIT_STORE_ITEM = new RpkitStoreItem();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitStoreItemRecord> getRecordType() {
        return RpkitStoreItemRecord.class;
    }

    /**
     * The column <code>rpkit_stores.rpkit_store_item.id</code>.
     */
    public final TableField<RpkitStoreItemRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>rpkit_stores.rpkit_store_item.plugin</code>.
     */
    public final TableField<RpkitStoreItemRecord, String> PLUGIN = createField(DSL.name("plugin"), SQLDataType.VARCHAR(128).nullable(false), this, "");

    /**
     * The column <code>rpkit_stores.rpkit_store_item.identifier</code>.
     */
    public final TableField<RpkitStoreItemRecord, String> IDENTIFIER = createField(DSL.name("identifier"), SQLDataType.VARCHAR(128).nullable(false), this, "");

    /**
     * The column <code>rpkit_stores.rpkit_store_item.description</code>.
     */
    public final TableField<RpkitStoreItemRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.VARCHAR(2048).nullable(false), this, "");

    /**
     * The column <code>rpkit_stores.rpkit_store_item.cost</code>.
     */
    public final TableField<RpkitStoreItemRecord, Integer> COST = createField(DSL.name("cost"), SQLDataType.INTEGER.nullable(false), this, "");

    private RpkitStoreItem(Name alias, Table<RpkitStoreItemRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitStoreItem(Name alias, Table<RpkitStoreItemRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>rpkit_stores.rpkit_store_item</code> table
     * reference
     */
    public RpkitStoreItem(String alias) {
        this(DSL.name(alias), RPKIT_STORE_ITEM);
    }

    /**
     * Create an aliased <code>rpkit_stores.rpkit_store_item</code> table
     * reference
     */
    public RpkitStoreItem(Name alias) {
        this(alias, RPKIT_STORE_ITEM);
    }

    /**
     * Create a <code>rpkit_stores.rpkit_store_item</code> table reference
     */
    public RpkitStoreItem() {
        this(DSL.name("rpkit_store_item"), null);
    }

    public <O extends Record> RpkitStoreItem(Table<O> child, ForeignKey<O, RpkitStoreItemRecord> key) {
        super(child, key, RPKIT_STORE_ITEM);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : RpkitStores.RPKIT_STORES;
    }

    @Override
    public Identity<RpkitStoreItemRecord, Integer> getIdentity() {
        return (Identity<RpkitStoreItemRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<RpkitStoreItemRecord> getPrimaryKey() {
        return Keys.KEY_RPKIT_STORE_ITEM_PRIMARY;
    }

    @Override
    public RpkitStoreItem as(String alias) {
        return new RpkitStoreItem(DSL.name(alias), this);
    }

    @Override
    public RpkitStoreItem as(Name alias) {
        return new RpkitStoreItem(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitStoreItem rename(String name) {
        return new RpkitStoreItem(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitStoreItem rename(Name name) {
        return new RpkitStoreItem(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, String, String, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
