/*
 * This file is generated by jOOQ.
 */
package com.rpkit.moderation.bukkit.database.jooq;


import com.rpkit.moderation.bukkit.database.jooq.tables.RpkitTicket;
import com.rpkit.moderation.bukkit.database.jooq.tables.RpkitVanished;
import com.rpkit.moderation.bukkit.database.jooq.tables.RpkitWarning;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RpkitModeration extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>rpkit_moderation</code>
     */
    public static final RpkitModeration RPKIT_MODERATION = new RpkitModeration();

    /**
     * The table <code>rpkit_moderation.rpkit_ticket</code>.
     */
    public final RpkitTicket RPKIT_TICKET = RpkitTicket.RPKIT_TICKET;

    /**
     * The table <code>rpkit_moderation.rpkit_vanished</code>.
     */
    public final RpkitVanished RPKIT_VANISHED = RpkitVanished.RPKIT_VANISHED;

    /**
     * The table <code>rpkit_moderation.rpkit_warning</code>.
     */
    public final RpkitWarning RPKIT_WARNING = RpkitWarning.RPKIT_WARNING;

    /**
     * No further instances allowed
     */
    private RpkitModeration() {
        super("rpkit_moderation", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            RpkitTicket.RPKIT_TICKET,
            RpkitVanished.RPKIT_VANISHED,
            RpkitWarning.RPKIT_WARNING
        );
    }
}
