/*
 * This file is generated by jOOQ.
 */
package com.rpkit.players.bukkit.database.jooq;


import com.rpkit.players.bukkit.database.jooq.tables.RpkitDiscordProfile;
import com.rpkit.players.bukkit.database.jooq.tables.RpkitGithubProfile;
import com.rpkit.players.bukkit.database.jooq.tables.RpkitIrcProfile;
import com.rpkit.players.bukkit.database.jooq.tables.RpkitMinecraftProfile;
import com.rpkit.players.bukkit.database.jooq.tables.RpkitProfile;
import com.rpkit.players.bukkit.database.jooq.tables.records.RpkitDiscordProfileRecord;
import com.rpkit.players.bukkit.database.jooq.tables.records.RpkitGithubProfileRecord;
import com.rpkit.players.bukkit.database.jooq.tables.records.RpkitIrcProfileRecord;
import com.rpkit.players.bukkit.database.jooq.tables.records.RpkitMinecraftProfileRecord;
import com.rpkit.players.bukkit.database.jooq.tables.records.RpkitProfileRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * rpkit_players.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<RpkitDiscordProfileRecord> KEY_RPKIT_DISCORD_PROFILE_PRIMARY = Internal.createUniqueKey(RpkitDiscordProfile.RPKIT_DISCORD_PROFILE, DSL.name("KEY_rpkit_discord_profile_PRIMARY"), new TableField[] { RpkitDiscordProfile.RPKIT_DISCORD_PROFILE.ID }, true);
    public static final UniqueKey<RpkitGithubProfileRecord> KEY_RPKIT_GITHUB_PROFILE_PRIMARY = Internal.createUniqueKey(RpkitGithubProfile.RPKIT_GITHUB_PROFILE, DSL.name("KEY_rpkit_github_profile_PRIMARY"), new TableField[] { RpkitGithubProfile.RPKIT_GITHUB_PROFILE.ID }, true);
    public static final UniqueKey<RpkitIrcProfileRecord> KEY_RPKIT_IRC_PROFILE_PRIMARY = Internal.createUniqueKey(RpkitIrcProfile.RPKIT_IRC_PROFILE, DSL.name("KEY_rpkit_irc_profile_PRIMARY"), new TableField[] { RpkitIrcProfile.RPKIT_IRC_PROFILE.ID }, true);
    public static final UniqueKey<RpkitMinecraftProfileRecord> KEY_RPKIT_MINECRAFT_PROFILE_PRIMARY = Internal.createUniqueKey(RpkitMinecraftProfile.RPKIT_MINECRAFT_PROFILE, DSL.name("KEY_rpkit_minecraft_profile_PRIMARY"), new TableField[] { RpkitMinecraftProfile.RPKIT_MINECRAFT_PROFILE.ID }, true);
    public static final UniqueKey<RpkitProfileRecord> KEY_RPKIT_PROFILE_PRIMARY = Internal.createUniqueKey(RpkitProfile.RPKIT_PROFILE, DSL.name("KEY_rpkit_profile_PRIMARY"), new TableField[] { RpkitProfile.RPKIT_PROFILE.ID }, true);
}
