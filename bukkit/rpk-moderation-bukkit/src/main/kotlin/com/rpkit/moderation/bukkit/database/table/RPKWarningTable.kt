/*
 * Copyright 2021 Ren Binden
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rpkit.moderation.bukkit.database.table

import com.rpkit.core.database.Database
import com.rpkit.core.database.Table
import com.rpkit.core.service.Services
import com.rpkit.moderation.bukkit.RPKModerationBukkit
import com.rpkit.moderation.bukkit.database.create
import com.rpkit.moderation.bukkit.database.jooq.Tables.RPKIT_WARNING
import com.rpkit.moderation.bukkit.warning.RPKWarning
import com.rpkit.moderation.bukkit.warning.RPKWarningId
import com.rpkit.moderation.bukkit.warning.RPKWarningImpl
import com.rpkit.players.bukkit.profile.RPKProfile
import com.rpkit.players.bukkit.profile.RPKProfileService


class RPKWarningTable(private val database: Database, private val plugin: RPKModerationBukkit) : Table {

    private val cache = if (plugin.config.getBoolean("caching.rpkit_warning.id.enabled")) {
        database.cacheManager.createCache(
            "rpk-moderation-bukkit.rpkit_warning.id",
            Int::class.javaObjectType,
            RPKWarning::class.java,
            plugin.config.getLong("caching.rpkit_warning.id.size")
        )
    } else {
        null
    }

    fun insert(entity: RPKWarning) {
        database.create
                .insertInto(
                        RPKIT_WARNING,
                        RPKIT_WARNING.REASON,
                        RPKIT_WARNING.PROFILE_ID,
                        RPKIT_WARNING.ISSUER_ID,
                        RPKIT_WARNING.TIME
                )
                .values(
                        entity.reason,
                        entity.profile.id,
                        entity.issuer.id,
                        entity.time
                )
                .execute()
        val id = database.create.lastID().toInt()
        entity.id = RPKWarningId(id)
        cache?.set(id, entity)
    }

    fun update(entity: RPKWarning) {
        val id = entity.id ?: return
        database.create
                .update(RPKIT_WARNING)
                .set(RPKIT_WARNING.REASON, entity.reason)
                .set(RPKIT_WARNING.PROFILE_ID, entity.profile.id)
                .set(RPKIT_WARNING.ISSUER_ID, entity.issuer.id)
                .set(RPKIT_WARNING.TIME, entity.time)
                .where(RPKIT_WARNING.ID.eq(id.value))
                .execute()
        cache?.set(id.value, entity)
    }

    operator fun get(id: RPKWarningId): RPKWarning? {
        val result = database.create
                .select(
                        RPKIT_WARNING.REASON,
                        RPKIT_WARNING.PROFILE_ID,
                        RPKIT_WARNING.ISSUER_ID,
                        RPKIT_WARNING.TIME
                )
                .from(RPKIT_WARNING)
                .where(RPKIT_WARNING.ID.eq(id.value))
                .fetchOne() ?: return null
        val profileService = Services[RPKProfileService::class.java] ?: return null
        val profile = profileService.getProfile(result[RPKIT_WARNING.PROFILE_ID])
        val issuer = profileService.getProfile(result[RPKIT_WARNING.ISSUER_ID])
        if (profile != null && issuer != null) {
            val warning = RPKWarningImpl(
                    id,
                    result[RPKIT_WARNING.REASON],
                    profile,
                    issuer,
                    result[RPKIT_WARNING.TIME]
            )
            cache?.set(id.value, warning)
            return warning
        } else {
            database.create
                    .deleteFrom(RPKIT_WARNING)
                    .where(RPKIT_WARNING.ID.eq(id.value))
                    .execute()
            cache?.remove(id.value)
            return null
        }
    }

    fun get(profile: RPKProfile): List<RPKWarning> {
        val results = database.create
                .select(RPKIT_WARNING.ID)
                .from(RPKIT_WARNING)
                .where(RPKIT_WARNING.PROFILE_ID.eq(profile.id))
                .fetch()
        return results.map { get(RPKWarningId(it[RPKIT_WARNING.ID])) }.filterNotNull()
    }

    fun delete(entity: RPKWarning) {
        val id = entity.id ?: return
        database.create
                .deleteFrom(RPKIT_WARNING)
                .where(RPKIT_WARNING.ID.eq(id.value))
                .execute()
        cache?.remove(id.value)
    }
}