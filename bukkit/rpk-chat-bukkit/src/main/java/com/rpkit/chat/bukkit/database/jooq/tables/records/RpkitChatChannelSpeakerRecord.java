/*
 * This file is generated by jOOQ.
 */
package com.rpkit.chat.bukkit.database.jooq.tables.records;


import com.rpkit.chat.bukkit.database.jooq.tables.RpkitChatChannelSpeaker;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitChatChannelSpeakerRecord extends TableRecordImpl<RpkitChatChannelSpeakerRecord> implements Record2<Integer, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for
     * <code>rpkit_chat.rpkit_chat_channel_speaker.minecraft_profile_id</code>.
     */
    public void setMinecraftProfileId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for
     * <code>rpkit_chat.rpkit_chat_channel_speaker.minecraft_profile_id</code>.
     */
    public Integer getMinecraftProfileId() {
        return (Integer) get(0);
    }

    /**
     * Setter for
     * <code>rpkit_chat.rpkit_chat_channel_speaker.chat_channel_name</code>.
     */
    public void setChatChannelName(String value) {
        set(1, value);
    }

    /**
     * Getter for
     * <code>rpkit_chat.rpkit_chat_channel_speaker.chat_channel_name</code>.
     */
    public String getChatChannelName() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Integer, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return RpkitChatChannelSpeaker.RPKIT_CHAT_CHANNEL_SPEAKER.MINECRAFT_PROFILE_ID;
    }

    @Override
    public Field<String> field2() {
        return RpkitChatChannelSpeaker.RPKIT_CHAT_CHANNEL_SPEAKER.CHAT_CHANNEL_NAME;
    }

    @Override
    public Integer component1() {
        return getMinecraftProfileId();
    }

    @Override
    public String component2() {
        return getChatChannelName();
    }

    @Override
    public Integer value1() {
        return getMinecraftProfileId();
    }

    @Override
    public String value2() {
        return getChatChannelName();
    }

    @Override
    public RpkitChatChannelSpeakerRecord value1(Integer value) {
        setMinecraftProfileId(value);
        return this;
    }

    @Override
    public RpkitChatChannelSpeakerRecord value2(String value) {
        setChatChannelName(value);
        return this;
    }

    @Override
    public RpkitChatChannelSpeakerRecord values(Integer value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RpkitChatChannelSpeakerRecord
     */
    public RpkitChatChannelSpeakerRecord() {
        super(RpkitChatChannelSpeaker.RPKIT_CHAT_CHANNEL_SPEAKER);
    }

    /**
     * Create a detached, initialised RpkitChatChannelSpeakerRecord
     */
    public RpkitChatChannelSpeakerRecord(Integer minecraftProfileId, String chatChannelName) {
        super(RpkitChatChannelSpeaker.RPKIT_CHAT_CHANNEL_SPEAKER);

        setMinecraftProfileId(minecraftProfileId);
        setChatChannelName(chatChannelName);
    }
}
