/*
 * This file is generated by jOOQ.
 */
package com.rpkit.featureflags.bukkit.database.jooq.tables;


import com.rpkit.featureflags.bukkit.database.jooq.RpkitFeatureFlags;
import com.rpkit.featureflags.bukkit.database.jooq.tables.records.RpkitProfileFeatureFlagRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitProfileFeatureFlag extends TableImpl<RpkitProfileFeatureFlagRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of
     * <code>rpkit_feature_flags.rpkit_profile_feature_flag</code>
     */
    public static final RpkitProfileFeatureFlag RPKIT_PROFILE_FEATURE_FLAG = new RpkitProfileFeatureFlag();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RpkitProfileFeatureFlagRecord> getRecordType() {
        return RpkitProfileFeatureFlagRecord.class;
    }

    /**
     * The column
     * <code>rpkit_feature_flags.rpkit_profile_feature_flag.profile_id</code>.
     */
    public final TableField<RpkitProfileFeatureFlagRecord, Integer> PROFILE_ID = createField(DSL.name("profile_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column
     * <code>rpkit_feature_flags.rpkit_profile_feature_flag.feature_flag_name</code>.
     */
    public final TableField<RpkitProfileFeatureFlagRecord, String> FEATURE_FLAG_NAME = createField(DSL.name("feature_flag_name"), SQLDataType.VARCHAR(1024).nullable(false), this, "");

    /**
     * The column
     * <code>rpkit_feature_flags.rpkit_profile_feature_flag.enabled</code>.
     */
    public final TableField<RpkitProfileFeatureFlagRecord, Boolean> ENABLED = createField(DSL.name("enabled"), SQLDataType.BOOLEAN.nullable(false), this, "");

    private RpkitProfileFeatureFlag(Name alias, Table<RpkitProfileFeatureFlagRecord> aliased) {
        this(alias, aliased, null);
    }

    private RpkitProfileFeatureFlag(Name alias, Table<RpkitProfileFeatureFlagRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased
     * <code>rpkit_feature_flags.rpkit_profile_feature_flag</code> table
     * reference
     */
    public RpkitProfileFeatureFlag(String alias) {
        this(DSL.name(alias), RPKIT_PROFILE_FEATURE_FLAG);
    }

    /**
     * Create an aliased
     * <code>rpkit_feature_flags.rpkit_profile_feature_flag</code> table
     * reference
     */
    public RpkitProfileFeatureFlag(Name alias) {
        this(alias, RPKIT_PROFILE_FEATURE_FLAG);
    }

    /**
     * Create a <code>rpkit_feature_flags.rpkit_profile_feature_flag</code>
     * table reference
     */
    public RpkitProfileFeatureFlag() {
        this(DSL.name("rpkit_profile_feature_flag"), null);
    }

    public <O extends Record> RpkitProfileFeatureFlag(Table<O> child, ForeignKey<O, RpkitProfileFeatureFlagRecord> key) {
        super(child, key, RPKIT_PROFILE_FEATURE_FLAG);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : RpkitFeatureFlags.RPKIT_FEATURE_FLAGS;
    }

    @Override
    public RpkitProfileFeatureFlag as(String alias) {
        return new RpkitProfileFeatureFlag(DSL.name(alias), this);
    }

    @Override
    public RpkitProfileFeatureFlag as(Name alias) {
        return new RpkitProfileFeatureFlag(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitProfileFeatureFlag rename(String name) {
        return new RpkitProfileFeatureFlag(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RpkitProfileFeatureFlag rename(Name name) {
        return new RpkitProfileFeatureFlag(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, Boolean> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
