/*
 * This file is generated by jOOQ.
 */
package com.rpkit.monsters.bukkit.database.jooq.tables.records;


import com.rpkit.monsters.bukkit.database.jooq.tables.RpkitMonsterSpawnAreaMonster;

import org.jooq.Field;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitMonsterSpawnAreaMonsterRecord extends TableRecordImpl<RpkitMonsterSpawnAreaMonsterRecord> implements Record4<Integer, String, Integer, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for
     * <code>rpkit_monsters.rpkit_monster_spawn_area_monster.monster_spawn_area_id</code>.
     */
    public void setMonsterSpawnAreaId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for
     * <code>rpkit_monsters.rpkit_monster_spawn_area_monster.monster_spawn_area_id</code>.
     */
    public Integer getMonsterSpawnAreaId() {
        return (Integer) get(0);
    }

    /**
     * Setter for
     * <code>rpkit_monsters.rpkit_monster_spawn_area_monster.entity_type</code>.
     */
    public void setEntityType(String value) {
        set(1, value);
    }

    /**
     * Getter for
     * <code>rpkit_monsters.rpkit_monster_spawn_area_monster.entity_type</code>.
     */
    public String getEntityType() {
        return (String) get(1);
    }

    /**
     * Setter for
     * <code>rpkit_monsters.rpkit_monster_spawn_area_monster.min_level</code>.
     */
    public void setMinLevel(Integer value) {
        set(2, value);
    }

    /**
     * Getter for
     * <code>rpkit_monsters.rpkit_monster_spawn_area_monster.min_level</code>.
     */
    public Integer getMinLevel() {
        return (Integer) get(2);
    }

    /**
     * Setter for
     * <code>rpkit_monsters.rpkit_monster_spawn_area_monster.max_level</code>.
     */
    public void setMaxLevel(Integer value) {
        set(3, value);
    }

    /**
     * Getter for
     * <code>rpkit_monsters.rpkit_monster_spawn_area_monster.max_level</code>.
     */
    public Integer getMaxLevel() {
        return (Integer) get(3);
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, Integer, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Integer, String, Integer, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return RpkitMonsterSpawnAreaMonster.RPKIT_MONSTER_SPAWN_AREA_MONSTER.MONSTER_SPAWN_AREA_ID;
    }

    @Override
    public Field<String> field2() {
        return RpkitMonsterSpawnAreaMonster.RPKIT_MONSTER_SPAWN_AREA_MONSTER.ENTITY_TYPE;
    }

    @Override
    public Field<Integer> field3() {
        return RpkitMonsterSpawnAreaMonster.RPKIT_MONSTER_SPAWN_AREA_MONSTER.MIN_LEVEL;
    }

    @Override
    public Field<Integer> field4() {
        return RpkitMonsterSpawnAreaMonster.RPKIT_MONSTER_SPAWN_AREA_MONSTER.MAX_LEVEL;
    }

    @Override
    public Integer component1() {
        return getMonsterSpawnAreaId();
    }

    @Override
    public String component2() {
        return getEntityType();
    }

    @Override
    public Integer component3() {
        return getMinLevel();
    }

    @Override
    public Integer component4() {
        return getMaxLevel();
    }

    @Override
    public Integer value1() {
        return getMonsterSpawnAreaId();
    }

    @Override
    public String value2() {
        return getEntityType();
    }

    @Override
    public Integer value3() {
        return getMinLevel();
    }

    @Override
    public Integer value4() {
        return getMaxLevel();
    }

    @Override
    public RpkitMonsterSpawnAreaMonsterRecord value1(Integer value) {
        setMonsterSpawnAreaId(value);
        return this;
    }

    @Override
    public RpkitMonsterSpawnAreaMonsterRecord value2(String value) {
        setEntityType(value);
        return this;
    }

    @Override
    public RpkitMonsterSpawnAreaMonsterRecord value3(Integer value) {
        setMinLevel(value);
        return this;
    }

    @Override
    public RpkitMonsterSpawnAreaMonsterRecord value4(Integer value) {
        setMaxLevel(value);
        return this;
    }

    @Override
    public RpkitMonsterSpawnAreaMonsterRecord values(Integer value1, String value2, Integer value3, Integer value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RpkitMonsterSpawnAreaMonsterRecord
     */
    public RpkitMonsterSpawnAreaMonsterRecord() {
        super(RpkitMonsterSpawnAreaMonster.RPKIT_MONSTER_SPAWN_AREA_MONSTER);
    }

    /**
     * Create a detached, initialised RpkitMonsterSpawnAreaMonsterRecord
     */
    public RpkitMonsterSpawnAreaMonsterRecord(Integer monsterSpawnAreaId, String entityType, Integer minLevel, Integer maxLevel) {
        super(RpkitMonsterSpawnAreaMonster.RPKIT_MONSTER_SPAWN_AREA_MONSTER);

        setMonsterSpawnAreaId(monsterSpawnAreaId);
        setEntityType(entityType);
        setMinLevel(minLevel);
        setMaxLevel(maxLevel);
    }
}
