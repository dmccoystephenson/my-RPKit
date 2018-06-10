/*
 * Copyright 2018 Ross Binden
 *
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

/*
 * This file is generated by jOOQ.
*/
package com.rpkit.permissions.bukkit.database.jooq.rpkit;


import com.rpkit.permissions.bukkit.database.jooq.rpkit.tables.PlayerGroup;
import com.rpkit.permissions.bukkit.database.jooq.rpkit.tables.RpkitCharacterGroup;
import com.rpkit.permissions.bukkit.database.jooq.rpkit.tables.RpkitProfileGroup;
import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.AbstractKeys;

import javax.annotation.Generated;


/**
 * A class modelling indexes of tables of the <code>rpkit</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index PLAYER_GROUP_PRIMARY = Indexes0.PLAYER_GROUP_PRIMARY;
    public static final Index RPKIT_CHARACTER_GROUP_PRIMARY = Indexes0.RPKIT_CHARACTER_GROUP_PRIMARY;
    public static final Index RPKIT_PROFILE_GROUP_PRIMARY = Indexes0.RPKIT_PROFILE_GROUP_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 extends AbstractKeys {
        public static Index PLAYER_GROUP_PRIMARY = createIndex("PRIMARY", PlayerGroup.PLAYER_GROUP, new OrderField[] { PlayerGroup.PLAYER_GROUP.ID }, true);
        public static Index RPKIT_CHARACTER_GROUP_PRIMARY = createIndex("PRIMARY", RpkitCharacterGroup.RPKIT_CHARACTER_GROUP, new OrderField[] { RpkitCharacterGroup.RPKIT_CHARACTER_GROUP.ID }, true);
        public static Index RPKIT_PROFILE_GROUP_PRIMARY = createIndex("PRIMARY", RpkitProfileGroup.RPKIT_PROFILE_GROUP, new OrderField[] { RpkitProfileGroup.RPKIT_PROFILE_GROUP.ID }, true);
    }
}
