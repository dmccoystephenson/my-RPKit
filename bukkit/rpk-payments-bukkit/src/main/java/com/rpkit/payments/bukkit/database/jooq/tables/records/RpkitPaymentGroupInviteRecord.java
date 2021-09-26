/*
 * This file is generated by jOOQ.
 */
package com.rpkit.payments.bukkit.database.jooq.tables.records;


import com.rpkit.payments.bukkit.database.jooq.tables.RpkitPaymentGroupInvite;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitPaymentGroupInviteRecord extends TableRecordImpl<RpkitPaymentGroupInviteRecord> implements Record2<Integer, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for
     * <code>rpkit_payments.rpkit_payment_group_invite.payment_group_id</code>.
     */
    public void setPaymentGroupId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for
     * <code>rpkit_payments.rpkit_payment_group_invite.payment_group_id</code>.
     */
    public Integer getPaymentGroupId() {
        return (Integer) get(0);
    }

    /**
     * Setter for
     * <code>rpkit_payments.rpkit_payment_group_invite.character_id</code>.
     */
    public void setCharacterId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for
     * <code>rpkit_payments.rpkit_payment_group_invite.character_id</code>.
     */
    public Integer getCharacterId() {
        return (Integer) get(1);
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Integer, Integer> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return RpkitPaymentGroupInvite.RPKIT_PAYMENT_GROUP_INVITE.PAYMENT_GROUP_ID;
    }

    @Override
    public Field<Integer> field2() {
        return RpkitPaymentGroupInvite.RPKIT_PAYMENT_GROUP_INVITE.CHARACTER_ID;
    }

    @Override
    public Integer component1() {
        return getPaymentGroupId();
    }

    @Override
    public Integer component2() {
        return getCharacterId();
    }

    @Override
    public Integer value1() {
        return getPaymentGroupId();
    }

    @Override
    public Integer value2() {
        return getCharacterId();
    }

    @Override
    public RpkitPaymentGroupInviteRecord value1(Integer value) {
        setPaymentGroupId(value);
        return this;
    }

    @Override
    public RpkitPaymentGroupInviteRecord value2(Integer value) {
        setCharacterId(value);
        return this;
    }

    @Override
    public RpkitPaymentGroupInviteRecord values(Integer value1, Integer value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RpkitPaymentGroupInviteRecord
     */
    public RpkitPaymentGroupInviteRecord() {
        super(RpkitPaymentGroupInvite.RPKIT_PAYMENT_GROUP_INVITE);
    }

    /**
     * Create a detached, initialised RpkitPaymentGroupInviteRecord
     */
    public RpkitPaymentGroupInviteRecord(Integer paymentGroupId, Integer characterId) {
        super(RpkitPaymentGroupInvite.RPKIT_PAYMENT_GROUP_INVITE);

        setPaymentGroupId(paymentGroupId);
        setCharacterId(characterId);
    }
}
