/*
 * This file is generated by jOOQ.
 */
package com.rpkit.store.bukkit.database.jooq;


import com.rpkit.store.bukkit.database.jooq.tables.RpkitConsumablePurchase;
import com.rpkit.store.bukkit.database.jooq.tables.RpkitConsumableStoreItem;
import com.rpkit.store.bukkit.database.jooq.tables.RpkitPermanentPurchase;
import com.rpkit.store.bukkit.database.jooq.tables.RpkitPermanentStoreItem;
import com.rpkit.store.bukkit.database.jooq.tables.RpkitPurchase;
import com.rpkit.store.bukkit.database.jooq.tables.RpkitStoreItem;
import com.rpkit.store.bukkit.database.jooq.tables.RpkitTimedPurchase;
import com.rpkit.store.bukkit.database.jooq.tables.RpkitTimedStoreItem;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitStores extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>rpkit_stores</code>
     */
    public static final RpkitStores RPKIT_STORES = new RpkitStores();

    /**
     * The table <code>rpkit_stores.rpkit_consumable_purchase</code>.
     */
    public final RpkitConsumablePurchase RPKIT_CONSUMABLE_PURCHASE = RpkitConsumablePurchase.RPKIT_CONSUMABLE_PURCHASE;

    /**
     * The table <code>rpkit_stores.rpkit_consumable_store_item</code>.
     */
    public final RpkitConsumableStoreItem RPKIT_CONSUMABLE_STORE_ITEM = RpkitConsumableStoreItem.RPKIT_CONSUMABLE_STORE_ITEM;

    /**
     * The table <code>rpkit_stores.rpkit_permanent_purchase</code>.
     */
    public final RpkitPermanentPurchase RPKIT_PERMANENT_PURCHASE = RpkitPermanentPurchase.RPKIT_PERMANENT_PURCHASE;

    /**
     * The table <code>rpkit_stores.rpkit_permanent_store_item</code>.
     */
    public final RpkitPermanentStoreItem RPKIT_PERMANENT_STORE_ITEM = RpkitPermanentStoreItem.RPKIT_PERMANENT_STORE_ITEM;

    /**
     * The table <code>rpkit_stores.rpkit_purchase</code>.
     */
    public final RpkitPurchase RPKIT_PURCHASE = RpkitPurchase.RPKIT_PURCHASE;

    /**
     * The table <code>rpkit_stores.rpkit_store_item</code>.
     */
    public final RpkitStoreItem RPKIT_STORE_ITEM = RpkitStoreItem.RPKIT_STORE_ITEM;

    /**
     * The table <code>rpkit_stores.rpkit_timed_purchase</code>.
     */
    public final RpkitTimedPurchase RPKIT_TIMED_PURCHASE = RpkitTimedPurchase.RPKIT_TIMED_PURCHASE;

    /**
     * The table <code>rpkit_stores.rpkit_timed_store_item</code>.
     */
    public final RpkitTimedStoreItem RPKIT_TIMED_STORE_ITEM = RpkitTimedStoreItem.RPKIT_TIMED_STORE_ITEM;

    /**
     * No further instances allowed
     */
    private RpkitStores() {
        super("rpkit_stores", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            RpkitConsumablePurchase.RPKIT_CONSUMABLE_PURCHASE,
            RpkitConsumableStoreItem.RPKIT_CONSUMABLE_STORE_ITEM,
            RpkitPermanentPurchase.RPKIT_PERMANENT_PURCHASE,
            RpkitPermanentStoreItem.RPKIT_PERMANENT_STORE_ITEM,
            RpkitPurchase.RPKIT_PURCHASE,
            RpkitStoreItem.RPKIT_STORE_ITEM,
            RpkitTimedPurchase.RPKIT_TIMED_PURCHASE,
            RpkitTimedStoreItem.RPKIT_TIMED_STORE_ITEM
        );
    }
}
