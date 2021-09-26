/*
 * This file is generated by jOOQ.
 */
package com.rpkit.craftingskill.bukkit.database.jooq.tables.records;


import com.rpkit.craftingskill.bukkit.database.jooq.tables.RpkitCraftingExperience;

import org.jooq.Field;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitCraftingExperienceRecord extends TableRecordImpl<RpkitCraftingExperienceRecord> implements Record4<Integer, String, String, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for
     * <code>rpkit_crafting_skill.rpkit_crafting_experience.character_id</code>.
     */
    public void setCharacterId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for
     * <code>rpkit_crafting_skill.rpkit_crafting_experience.character_id</code>.
     */
    public Integer getCharacterId() {
        return (Integer) get(0);
    }

    /**
     * Setter for
     * <code>rpkit_crafting_skill.rpkit_crafting_experience.action</code>.
     */
    public void setAction(String value) {
        set(1, value);
    }

    /**
     * Getter for
     * <code>rpkit_crafting_skill.rpkit_crafting_experience.action</code>.
     */
    public String getAction() {
        return (String) get(1);
    }

    /**
     * Setter for
     * <code>rpkit_crafting_skill.rpkit_crafting_experience.material</code>.
     */
    public void setMaterial(String value) {
        set(2, value);
    }

    /**
     * Getter for
     * <code>rpkit_crafting_skill.rpkit_crafting_experience.material</code>.
     */
    public String getMaterial() {
        return (String) get(2);
    }

    /**
     * Setter for
     * <code>rpkit_crafting_skill.rpkit_crafting_experience.experience</code>.
     */
    public void setExperience(Integer value) {
        set(3, value);
    }

    /**
     * Getter for
     * <code>rpkit_crafting_skill.rpkit_crafting_experience.experience</code>.
     */
    public Integer getExperience() {
        return (Integer) get(3);
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, String, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Integer, String, String, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return RpkitCraftingExperience.RPKIT_CRAFTING_EXPERIENCE.CHARACTER_ID;
    }

    @Override
    public Field<String> field2() {
        return RpkitCraftingExperience.RPKIT_CRAFTING_EXPERIENCE.ACTION;
    }

    @Override
    public Field<String> field3() {
        return RpkitCraftingExperience.RPKIT_CRAFTING_EXPERIENCE.MATERIAL;
    }

    @Override
    public Field<Integer> field4() {
        return RpkitCraftingExperience.RPKIT_CRAFTING_EXPERIENCE.EXPERIENCE;
    }

    @Override
    public Integer component1() {
        return getCharacterId();
    }

    @Override
    public String component2() {
        return getAction();
    }

    @Override
    public String component3() {
        return getMaterial();
    }

    @Override
    public Integer component4() {
        return getExperience();
    }

    @Override
    public Integer value1() {
        return getCharacterId();
    }

    @Override
    public String value2() {
        return getAction();
    }

    @Override
    public String value3() {
        return getMaterial();
    }

    @Override
    public Integer value4() {
        return getExperience();
    }

    @Override
    public RpkitCraftingExperienceRecord value1(Integer value) {
        setCharacterId(value);
        return this;
    }

    @Override
    public RpkitCraftingExperienceRecord value2(String value) {
        setAction(value);
        return this;
    }

    @Override
    public RpkitCraftingExperienceRecord value3(String value) {
        setMaterial(value);
        return this;
    }

    @Override
    public RpkitCraftingExperienceRecord value4(Integer value) {
        setExperience(value);
        return this;
    }

    @Override
    public RpkitCraftingExperienceRecord values(Integer value1, String value2, String value3, Integer value4) {
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
     * Create a detached RpkitCraftingExperienceRecord
     */
    public RpkitCraftingExperienceRecord() {
        super(RpkitCraftingExperience.RPKIT_CRAFTING_EXPERIENCE);
    }

    /**
     * Create a detached, initialised RpkitCraftingExperienceRecord
     */
    public RpkitCraftingExperienceRecord(Integer characterId, String action, String material, Integer experience) {
        super(RpkitCraftingExperience.RPKIT_CRAFTING_EXPERIENCE);

        setCharacterId(characterId);
        setAction(action);
        setMaterial(material);
        setExperience(experience);
    }
}
