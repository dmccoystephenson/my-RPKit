/*
 * This file is generated by jOOQ.
 */
package com.rpkit.shops.bukkit.database.jooq;


import com.rpkit.shops.bukkit.database.jooq.tables.RpkitShopCount;
import com.rpkit.shops.bukkit.database.jooq.tables.records.RpkitShopCountRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * rpkit_shops.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<RpkitShopCountRecord> KEY_RPKIT_SHOP_COUNT_PRIMARY = Internal.createUniqueKey(RpkitShopCount.RPKIT_SHOP_COUNT, DSL.name("KEY_rpkit_shop_count_PRIMARY"), new TableField[] { RpkitShopCount.RPKIT_SHOP_COUNT.CHARACTER_ID }, true);
}
