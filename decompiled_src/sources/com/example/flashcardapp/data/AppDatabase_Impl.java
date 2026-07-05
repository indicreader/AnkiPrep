package com.example.flashcardapp.data;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.example.flashcardapp.data.dao.AliasDao;
import com.example.flashcardapp.data.dao.AliasDao_Impl;
import com.example.flashcardapp.data.dao.CardAttemptDao;
import com.example.flashcardapp.data.dao.CardAttemptDao_Impl;
import com.example.flashcardapp.data.dao.CardDao;
import com.example.flashcardapp.data.dao.CardDao_Impl;
import com.example.flashcardapp.data.dao.CardOverrideDao;
import com.example.flashcardapp.data.dao.CardOverrideDao_Impl;
import com.example.flashcardapp.data.dao.CardStateDao;
import com.example.flashcardapp.data.dao.CardStateDao_Impl;
import com.example.flashcardapp.data.dao.CardUserMetadataDao;
import com.example.flashcardapp.data.dao.CardUserMetadataDao_Impl;
import com.example.flashcardapp.data.dao.DeckDao;
import com.example.flashcardapp.data.dao.DeckDao_Impl;
import com.example.flashcardapp.data.dao.DeckProgressLedgerDao;
import com.example.flashcardapp.data.dao.DeckProgressLedgerDao_Impl;
import com.example.flashcardapp.data.dao.SessionRecordDao;
import com.example.flashcardapp.data.dao.SessionRecordDao_Impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppDatabase_Impl.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0014J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0014J\b\u0010$\u001a\u00020\u0011H\u0016J\b\u0010%\u001a\u00020\u0013H\u0016J*\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u001a\u0010)\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020,0+\u0012\u0004\u0012\u00020,0*H\u0016J\u0016\u0010-\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020,0+0.H\u0016J*\u0010/\u001a$\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002000+\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002000+0'0*H\u0014J\b\u00101\u001a\u00020\u0015H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/example/flashcardapp/data/AppDatabase_Impl;", "Lcom/example/flashcardapp/data/AppDatabase;", "()V", "_aliasDao", "Lkotlin/Lazy;", "Lcom/example/flashcardapp/data/dao/AliasDao;", "_cardAttemptDao", "Lcom/example/flashcardapp/data/dao/CardAttemptDao;", "_cardDao", "Lcom/example/flashcardapp/data/dao/CardDao;", "_cardOverrideDao", "Lcom/example/flashcardapp/data/dao/CardOverrideDao;", "_cardStateDao", "Lcom/example/flashcardapp/data/dao/CardStateDao;", "_cardUserMetadataDao", "Lcom/example/flashcardapp/data/dao/CardUserMetadataDao;", "_deckDao", "Lcom/example/flashcardapp/data/dao/DeckDao;", "_deckProgressLedgerDao", "Lcom/example/flashcardapp/data/dao/DeckProgressLedgerDao;", "_sessionRecordDao", "Lcom/example/flashcardapp/data/dao/SessionRecordDao;", "aliasDao", "cardAttemptDao", "cardDao", "cardOverrideDao", "cardStateDao", "cardUserMetadataDao", "clearAllTables", "", "createInvalidationTracker", "Landroidx/room/InvalidationTracker;", "createOpenHelper", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "config", "Landroidx/room/DatabaseConfiguration;", "deckDao", "deckProgressLedgerDao", "getAutoMigrations", "", "Landroidx/room/migration/Migration;", "autoMigrationSpecs", "", "Ljava/lang/Class;", "Landroidx/room/migration/AutoMigrationSpec;", "getRequiredAutoMigrationSpecs", "", "getRequiredTypeConverters", "", "sessionRecordDao", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class AppDatabase_Impl extends AppDatabase {
    public static final int $stable = 8;
    private final Lazy<DeckDao> _deckDao = LazyKt.lazy(new Function0<DeckDao_Impl>() { // from class: com.example.flashcardapp.data.AppDatabase_Impl$_deckDao$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DeckDao_Impl invoke() {
            return new DeckDao_Impl(AppDatabase_Impl.this);
        }
    });
    private final Lazy<CardDao> _cardDao = LazyKt.lazy(new Function0<CardDao_Impl>() { // from class: com.example.flashcardapp.data.AppDatabase_Impl$_cardDao$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CardDao_Impl invoke() {
            return new CardDao_Impl(AppDatabase_Impl.this);
        }
    });
    private final Lazy<SessionRecordDao> _sessionRecordDao = LazyKt.lazy(new Function0<SessionRecordDao_Impl>() { // from class: com.example.flashcardapp.data.AppDatabase_Impl$_sessionRecordDao$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SessionRecordDao_Impl invoke() {
            return new SessionRecordDao_Impl(AppDatabase_Impl.this);
        }
    });
    private final Lazy<CardOverrideDao> _cardOverrideDao = LazyKt.lazy(new Function0<CardOverrideDao_Impl>() { // from class: com.example.flashcardapp.data.AppDatabase_Impl$_cardOverrideDao$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CardOverrideDao_Impl invoke() {
            return new CardOverrideDao_Impl(AppDatabase_Impl.this);
        }
    });
    private final Lazy<CardAttemptDao> _cardAttemptDao = LazyKt.lazy(new Function0<CardAttemptDao_Impl>() { // from class: com.example.flashcardapp.data.AppDatabase_Impl$_cardAttemptDao$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CardAttemptDao_Impl invoke() {
            return new CardAttemptDao_Impl(AppDatabase_Impl.this);
        }
    });
    private final Lazy<CardStateDao> _cardStateDao = LazyKt.lazy(new Function0<CardStateDao_Impl>() { // from class: com.example.flashcardapp.data.AppDatabase_Impl$_cardStateDao$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CardStateDao_Impl invoke() {
            return new CardStateDao_Impl(AppDatabase_Impl.this);
        }
    });
    private final Lazy<AliasDao> _aliasDao = LazyKt.lazy(new Function0<AliasDao_Impl>() { // from class: com.example.flashcardapp.data.AppDatabase_Impl$_aliasDao$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AliasDao_Impl invoke() {
            return new AliasDao_Impl(AppDatabase_Impl.this);
        }
    });
    private final Lazy<CardUserMetadataDao> _cardUserMetadataDao = LazyKt.lazy(new Function0<CardUserMetadataDao_Impl>() { // from class: com.example.flashcardapp.data.AppDatabase_Impl$_cardUserMetadataDao$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CardUserMetadataDao_Impl invoke() {
            return new CardUserMetadataDao_Impl(AppDatabase_Impl.this);
        }
    });
    private final Lazy<DeckProgressLedgerDao> _deckProgressLedgerDao = LazyKt.lazy(new Function0<DeckProgressLedgerDao_Impl>() { // from class: com.example.flashcardapp.data.AppDatabase_Impl$_deckProgressLedgerDao$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DeckProgressLedgerDao_Impl invoke() {
            return new DeckProgressLedgerDao_Impl(AppDatabase_Impl.this);
        }
    });

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return config.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.INSTANCE.builder(config.context).name(config.name).callback(new RoomOpenHelper(config, new RoomOpenHelper.Delegate() { // from class: com.example.flashcardapp.data.AppDatabase_Impl$createOpenHelper$_openCallback$1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase db) {
                Intrinsics.checkNotNullParameter(db, "db");
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(11);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase db) {
                Intrinsics.checkNotNullParameter(db, "db");
                db.execSQL("CREATE TABLE IF NOT EXISTS `decks` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `fullPath` TEXT NOT NULL, `parentDeckId` INTEGER, `cardCount` INTEGER NOT NULL, `description` TEXT NOT NULL, `lastSyncTimestamp` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `cards` (`id` INTEGER NOT NULL, `noteId` INTEGER NOT NULL, `deckId` INTEGER NOT NULL, `subDeckId` INTEGER, `front` TEXT NOT NULL, `back` TEXT NOT NULL, `tags` TEXT NOT NULL, `deckHierarchy` TEXT NOT NULL, `lastSyncTimestamp` INTEGER NOT NULL, `frontImage` TEXT, `backImage` TEXT, `explanationImage` TEXT, `optionImagesJson` TEXT, PRIMARY KEY(`id`), FOREIGN KEY(`deckId`) REFERENCES `decks`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_cards_deckId` ON `cards` (`deckId`)");
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_cards_noteId` ON `cards` (`noteId`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `session_records` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `deckId` INTEGER NOT NULL, `deckName` TEXT NOT NULL, `mode` TEXT NOT NULL, `score` INTEGER NOT NULL, `totalQuestions` INTEGER NOT NULL, `timeTakenSeconds` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `card_overrides` (`cardId` INTEGER NOT NULL, `frontOverride` TEXT NOT NULL, `backOverride` TEXT NOT NULL, `tagsOverride` TEXT, `timestamp` INTEGER NOT NULL, `frontImageOverride` TEXT, `backImageOverride` TEXT, `explanationImageOverride` TEXT, `optionImagesOverrideJson` TEXT, PRIMARY KEY(`cardId`), FOREIGN KEY(`cardId`) REFERENCES `cards`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                db.execSQL("CREATE TABLE IF NOT EXISTS `card_attempts` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `cardId` INTEGER NOT NULL, `deckId` INTEGER NOT NULL, `isCorrect` INTEGER NOT NULL, `timeTakenMs` INTEGER NOT NULL, `fsrsRating` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `card_states` (`cardId` INTEGER NOT NULL, `stability` REAL NOT NULL, `difficulty` REAL NOT NULL, `interval` INTEGER NOT NULL, `dueDate` INTEGER NOT NULL, `lastReview` INTEGER NOT NULL, `reviewCount` INTEGER NOT NULL, `lapses` INTEGER NOT NULL, `state` INTEGER NOT NULL, `retrievability` REAL NOT NULL, `retrievabilityTimestamp` INTEGER NOT NULL, PRIMARY KEY(`cardId`), FOREIGN KEY(`cardId`) REFERENCES `cards`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_card_states_cardId` ON `card_states` (`cardId`)");
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_card_states_dueDate` ON `card_states` (`dueDate`)");
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_card_states_state` ON `card_states` (`state`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `aliases` (`name` TEXT NOT NULL, `alias` TEXT NOT NULL, PRIMARY KEY(`name`, `alias`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `card_user_metadata` (`cardId` INTEGER NOT NULL, `isStarred` INTEGER NOT NULL, `rating` INTEGER NOT NULL, PRIMARY KEY(`cardId`), FOREIGN KEY(`cardId`) REFERENCES `cards`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_card_user_metadata_cardId` ON `card_user_metadata` (`cardId`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `DeckProgressLedger` (`cardId` INTEGER NOT NULL, `deckId` INTEGER NOT NULL, PRIMARY KEY(`cardId`), FOREIGN KEY(`cardId`) REFERENCES `cards`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_DeckProgressLedger_cardId` ON `DeckProgressLedger` (`cardId`)");
                db.execSQL(RoomMasterTable.CREATE_QUERY);
                db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f3d9bb170e616d0baf39a3e8753a1846')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase db) {
                List list;
                Intrinsics.checkNotNullParameter(db, "db");
                db.execSQL("DROP TABLE IF EXISTS `decks`");
                db.execSQL("DROP TABLE IF EXISTS `cards`");
                db.execSQL("DROP TABLE IF EXISTS `session_records`");
                db.execSQL("DROP TABLE IF EXISTS `card_overrides`");
                db.execSQL("DROP TABLE IF EXISTS `card_attempts`");
                db.execSQL("DROP TABLE IF EXISTS `card_states`");
                db.execSQL("DROP TABLE IF EXISTS `aliases`");
                db.execSQL("DROP TABLE IF EXISTS `card_user_metadata`");
                db.execSQL("DROP TABLE IF EXISTS `DeckProgressLedger`");
                list = AppDatabase_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onDestructiveMigration(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(SupportSQLiteDatabase db) {
                List list;
                Intrinsics.checkNotNullParameter(db, "db");
                list = AppDatabase_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onCreate(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase db) {
                List list;
                Intrinsics.checkNotNullParameter(db, "db");
                AppDatabase_Impl.this.mDatabase = db;
                db.execSQL("PRAGMA foreign_keys = ON");
                AppDatabase_Impl.this.internalInitInvalidationTracker(db);
                list = AppDatabase_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onOpen(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(SupportSQLiteDatabase db) {
                Intrinsics.checkNotNullParameter(db, "db");
                DBUtil.dropFtsSyncTriggers(db);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase db) {
                Intrinsics.checkNotNullParameter(db, "db");
                HashMap hashMap = new HashMap(7);
                hashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                hashMap.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                hashMap.put("fullPath", new TableInfo.Column("fullPath", "TEXT", true, 0, null, 1));
                hashMap.put("parentDeckId", new TableInfo.Column("parentDeckId", "INTEGER", false, 0, null, 1));
                hashMap.put("cardCount", new TableInfo.Column("cardCount", "INTEGER", true, 0, null, 1));
                hashMap.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, 1));
                hashMap.put("lastSyncTimestamp", new TableInfo.Column("lastSyncTimestamp", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo = new TableInfo("decks", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.INSTANCE.read(db, "decks");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "decks(com.example.flashcardapp.data.entities.DeckEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(13);
                hashMap2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                hashMap2.put("noteId", new TableInfo.Column("noteId", "INTEGER", true, 0, null, 1));
                hashMap2.put("deckId", new TableInfo.Column("deckId", "INTEGER", true, 0, null, 1));
                hashMap2.put("subDeckId", new TableInfo.Column("subDeckId", "INTEGER", false, 0, null, 1));
                hashMap2.put("front", new TableInfo.Column("front", "TEXT", true, 0, null, 1));
                hashMap2.put("back", new TableInfo.Column("back", "TEXT", true, 0, null, 1));
                hashMap2.put("tags", new TableInfo.Column("tags", "TEXT", true, 0, null, 1));
                hashMap2.put("deckHierarchy", new TableInfo.Column("deckHierarchy", "TEXT", true, 0, null, 1));
                hashMap2.put("lastSyncTimestamp", new TableInfo.Column("lastSyncTimestamp", "INTEGER", true, 0, null, 1));
                hashMap2.put("frontImage", new TableInfo.Column("frontImage", "TEXT", false, 0, null, 1));
                hashMap2.put("backImage", new TableInfo.Column("backImage", "TEXT", false, 0, null, 1));
                hashMap2.put("explanationImage", new TableInfo.Column("explanationImage", "TEXT", false, 0, null, 1));
                hashMap2.put("optionImagesJson", new TableInfo.Column("optionImagesJson", "TEXT", false, 0, null, 1));
                HashSet hashSet = new HashSet(1);
                hashSet.add(new TableInfo.ForeignKey("decks", "CASCADE", "NO ACTION", CollectionsKt.listOf("deckId"), CollectionsKt.listOf("id")));
                HashSet hashSet2 = new HashSet(2);
                hashSet2.add(new TableInfo.Index("index_cards_deckId", false, CollectionsKt.listOf("deckId"), CollectionsKt.listOf("ASC")));
                hashSet2.add(new TableInfo.Index("index_cards_noteId", false, CollectionsKt.listOf("noteId"), CollectionsKt.listOf("ASC")));
                TableInfo tableInfo2 = new TableInfo("cards", hashMap2, hashSet, hashSet2);
                TableInfo read2 = TableInfo.INSTANCE.read(db, "cards");
                if (!tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(false, "cards(com.example.flashcardapp.data.entities.CardEntity).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                HashMap hashMap3 = new HashMap(8);
                hashMap3.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                hashMap3.put("deckId", new TableInfo.Column("deckId", "INTEGER", true, 0, null, 1));
                hashMap3.put("deckName", new TableInfo.Column("deckName", "TEXT", true, 0, null, 1));
                hashMap3.put("mode", new TableInfo.Column("mode", "TEXT", true, 0, null, 1));
                hashMap3.put("score", new TableInfo.Column("score", "INTEGER", true, 0, null, 1));
                hashMap3.put("totalQuestions", new TableInfo.Column("totalQuestions", "INTEGER", true, 0, null, 1));
                hashMap3.put("timeTakenSeconds", new TableInfo.Column("timeTakenSeconds", "INTEGER", true, 0, null, 1));
                hashMap3.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo3 = new TableInfo("session_records", hashMap3, new HashSet(0), new HashSet(0));
                TableInfo read3 = TableInfo.INSTANCE.read(db, "session_records");
                if (!tableInfo3.equals(read3)) {
                    return new RoomOpenHelper.ValidationResult(false, "session_records(com.example.flashcardapp.data.entities.SessionRecordEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
                }
                HashMap hashMap4 = new HashMap(9);
                hashMap4.put("cardId", new TableInfo.Column("cardId", "INTEGER", true, 1, null, 1));
                hashMap4.put("frontOverride", new TableInfo.Column("frontOverride", "TEXT", true, 0, null, 1));
                hashMap4.put("backOverride", new TableInfo.Column("backOverride", "TEXT", true, 0, null, 1));
                hashMap4.put("tagsOverride", new TableInfo.Column("tagsOverride", "TEXT", false, 0, null, 1));
                hashMap4.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, 1));
                hashMap4.put("frontImageOverride", new TableInfo.Column("frontImageOverride", "TEXT", false, 0, null, 1));
                hashMap4.put("backImageOverride", new TableInfo.Column("backImageOverride", "TEXT", false, 0, null, 1));
                hashMap4.put("explanationImageOverride", new TableInfo.Column("explanationImageOverride", "TEXT", false, 0, null, 1));
                hashMap4.put("optionImagesOverrideJson", new TableInfo.Column("optionImagesOverrideJson", "TEXT", false, 0, null, 1));
                HashSet hashSet3 = new HashSet(1);
                hashSet3.add(new TableInfo.ForeignKey("cards", "CASCADE", "NO ACTION", CollectionsKt.listOf("cardId"), CollectionsKt.listOf("id")));
                TableInfo tableInfo4 = new TableInfo("card_overrides", hashMap4, hashSet3, new HashSet(0));
                TableInfo read4 = TableInfo.INSTANCE.read(db, "card_overrides");
                if (!tableInfo4.equals(read4)) {
                    return new RoomOpenHelper.ValidationResult(false, "card_overrides(com.example.flashcardapp.data.entities.CardOverrideEntity).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
                }
                HashMap hashMap5 = new HashMap(7);
                hashMap5.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                hashMap5.put("cardId", new TableInfo.Column("cardId", "INTEGER", true, 0, null, 1));
                hashMap5.put("deckId", new TableInfo.Column("deckId", "INTEGER", true, 0, null, 1));
                hashMap5.put("isCorrect", new TableInfo.Column("isCorrect", "INTEGER", true, 0, null, 1));
                hashMap5.put("timeTakenMs", new TableInfo.Column("timeTakenMs", "INTEGER", true, 0, null, 1));
                hashMap5.put("fsrsRating", new TableInfo.Column("fsrsRating", "INTEGER", true, 0, null, 1));
                hashMap5.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo5 = new TableInfo("card_attempts", hashMap5, new HashSet(0), new HashSet(0));
                TableInfo read5 = TableInfo.INSTANCE.read(db, "card_attempts");
                if (!tableInfo5.equals(read5)) {
                    return new RoomOpenHelper.ValidationResult(false, "card_attempts(com.example.flashcardapp.data.entities.CardAttemptEntity).\n Expected:\n" + tableInfo5 + "\n Found:\n" + read5);
                }
                HashMap hashMap6 = new HashMap(11);
                hashMap6.put("cardId", new TableInfo.Column("cardId", "INTEGER", true, 1, null, 1));
                hashMap6.put("stability", new TableInfo.Column("stability", "REAL", true, 0, null, 1));
                hashMap6.put("difficulty", new TableInfo.Column("difficulty", "REAL", true, 0, null, 1));
                hashMap6.put("interval", new TableInfo.Column("interval", "INTEGER", true, 0, null, 1));
                hashMap6.put("dueDate", new TableInfo.Column("dueDate", "INTEGER", true, 0, null, 1));
                hashMap6.put("lastReview", new TableInfo.Column("lastReview", "INTEGER", true, 0, null, 1));
                hashMap6.put("reviewCount", new TableInfo.Column("reviewCount", "INTEGER", true, 0, null, 1));
                hashMap6.put("lapses", new TableInfo.Column("lapses", "INTEGER", true, 0, null, 1));
                hashMap6.put("state", new TableInfo.Column("state", "INTEGER", true, 0, null, 1));
                hashMap6.put("retrievability", new TableInfo.Column("retrievability", "REAL", true, 0, null, 1));
                hashMap6.put("retrievabilityTimestamp", new TableInfo.Column("retrievabilityTimestamp", "INTEGER", true, 0, null, 1));
                HashSet hashSet4 = new HashSet(1);
                hashSet4.add(new TableInfo.ForeignKey("cards", "CASCADE", "NO ACTION", CollectionsKt.listOf("cardId"), CollectionsKt.listOf("id")));
                HashSet hashSet5 = new HashSet(3);
                hashSet5.add(new TableInfo.Index("index_card_states_cardId", true, CollectionsKt.listOf("cardId"), CollectionsKt.listOf("ASC")));
                hashSet5.add(new TableInfo.Index("index_card_states_dueDate", false, CollectionsKt.listOf("dueDate"), CollectionsKt.listOf("ASC")));
                hashSet5.add(new TableInfo.Index("index_card_states_state", false, CollectionsKt.listOf("state"), CollectionsKt.listOf("ASC")));
                TableInfo tableInfo6 = new TableInfo("card_states", hashMap6, hashSet4, hashSet5);
                TableInfo read6 = TableInfo.INSTANCE.read(db, "card_states");
                if (!tableInfo6.equals(read6)) {
                    return new RoomOpenHelper.ValidationResult(false, "card_states(com.example.flashcardapp.data.entities.CardStateEntity).\n Expected:\n" + tableInfo6 + "\n Found:\n" + read6);
                }
                HashMap hashMap7 = new HashMap(2);
                hashMap7.put("name", new TableInfo.Column("name", "TEXT", true, 1, null, 1));
                hashMap7.put("alias", new TableInfo.Column("alias", "TEXT", true, 2, null, 1));
                TableInfo tableInfo7 = new TableInfo("aliases", hashMap7, new HashSet(0), new HashSet(0));
                TableInfo read7 = TableInfo.INSTANCE.read(db, "aliases");
                if (!tableInfo7.equals(read7)) {
                    return new RoomOpenHelper.ValidationResult(false, "aliases(com.example.flashcardapp.data.entities.AliasEntity).\n Expected:\n" + tableInfo7 + "\n Found:\n" + read7);
                }
                HashMap hashMap8 = new HashMap(3);
                hashMap8.put("cardId", new TableInfo.Column("cardId", "INTEGER", true, 1, null, 1));
                hashMap8.put("isStarred", new TableInfo.Column("isStarred", "INTEGER", true, 0, null, 1));
                hashMap8.put("rating", new TableInfo.Column("rating", "INTEGER", true, 0, null, 1));
                HashSet hashSet6 = new HashSet(1);
                hashSet6.add(new TableInfo.ForeignKey("cards", "CASCADE", "NO ACTION", CollectionsKt.listOf("cardId"), CollectionsKt.listOf("id")));
                HashSet hashSet7 = new HashSet(1);
                hashSet7.add(new TableInfo.Index("index_card_user_metadata_cardId", true, CollectionsKt.listOf("cardId"), CollectionsKt.listOf("ASC")));
                TableInfo tableInfo8 = new TableInfo("card_user_metadata", hashMap8, hashSet6, hashSet7);
                TableInfo read8 = TableInfo.INSTANCE.read(db, "card_user_metadata");
                if (!tableInfo8.equals(read8)) {
                    return new RoomOpenHelper.ValidationResult(false, "card_user_metadata(com.example.flashcardapp.data.entities.CardUserMetadataEntity).\n Expected:\n" + tableInfo8 + "\n Found:\n" + read8);
                }
                HashMap hashMap9 = new HashMap(2);
                hashMap9.put("cardId", new TableInfo.Column("cardId", "INTEGER", true, 1, null, 1));
                hashMap9.put("deckId", new TableInfo.Column("deckId", "INTEGER", true, 0, null, 1));
                HashSet hashSet8 = new HashSet(1);
                hashSet8.add(new TableInfo.ForeignKey("cards", "CASCADE", "NO ACTION", CollectionsKt.listOf("cardId"), CollectionsKt.listOf("id")));
                HashSet hashSet9 = new HashSet(1);
                hashSet9.add(new TableInfo.Index("index_DeckProgressLedger_cardId", true, CollectionsKt.listOf("cardId"), CollectionsKt.listOf("ASC")));
                TableInfo tableInfo9 = new TableInfo("DeckProgressLedger", hashMap9, hashSet8, hashSet9);
                TableInfo read9 = TableInfo.INSTANCE.read(db, "DeckProgressLedger");
                if (!tableInfo9.equals(read9)) {
                    return new RoomOpenHelper.ValidationResult(false, "DeckProgressLedger(com.example.flashcardapp.data.entities.DeckProgressLedger).\n Expected:\n" + tableInfo9 + "\n Found:\n" + read9);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "f3d9bb170e616d0baf39a3e8753a1846", "902a87ca3b9be3291a2952915e0bc416")).build());
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "decks", "cards", "session_records", "card_overrides", "card_attempts", "card_states", "aliases", "card_user_metadata", "DeckProgressLedger");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("PRAGMA defer_foreign_keys = TRUE");
            writableDatabase.execSQL("DELETE FROM `decks`");
            writableDatabase.execSQL("DELETE FROM `cards`");
            writableDatabase.execSQL("DELETE FROM `session_records`");
            writableDatabase.execSQL("DELETE FROM `card_overrides`");
            writableDatabase.execSQL("DELETE FROM `card_attempts`");
            writableDatabase.execSQL("DELETE FROM `card_states`");
            writableDatabase.execSQL("DELETE FROM `aliases`");
            writableDatabase.execSQL("DELETE FROM `card_user_metadata`");
            writableDatabase.execSQL("DELETE FROM `DeckProgressLedger`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<? extends Object>, List<Class<? extends Object>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(DeckDao.class, DeckDao_Impl.INSTANCE.getRequiredConverters());
        hashMap.put(CardDao.class, CardDao_Impl.INSTANCE.getRequiredConverters());
        hashMap.put(SessionRecordDao.class, SessionRecordDao_Impl.INSTANCE.getRequiredConverters());
        hashMap.put(CardOverrideDao.class, CardOverrideDao_Impl.INSTANCE.getRequiredConverters());
        hashMap.put(CardAttemptDao.class, CardAttemptDao_Impl.INSTANCE.getRequiredConverters());
        hashMap.put(CardStateDao.class, CardStateDao_Impl.INSTANCE.getRequiredConverters());
        hashMap.put(AliasDao.class, AliasDao_Impl.INSTANCE.getRequiredConverters());
        hashMap.put(CardUserMetadataDao.class, CardUserMetadataDao_Impl.INSTANCE.getRequiredConverters());
        hashMap.put(DeckProgressLedgerDao.class, DeckProgressLedgerDao_Impl.INSTANCE.getRequiredConverters());
        return hashMap;
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, ? extends AutoMigrationSpec> autoMigrationSpecs) {
        Intrinsics.checkNotNullParameter(autoMigrationSpecs, "autoMigrationSpecs");
        return new ArrayList();
    }

    @Override // com.example.flashcardapp.data.AppDatabase
    public DeckDao deckDao() {
        return this._deckDao.getValue();
    }

    @Override // com.example.flashcardapp.data.AppDatabase
    public CardDao cardDao() {
        return this._cardDao.getValue();
    }

    @Override // com.example.flashcardapp.data.AppDatabase
    public SessionRecordDao sessionRecordDao() {
        return this._sessionRecordDao.getValue();
    }

    @Override // com.example.flashcardapp.data.AppDatabase
    public CardOverrideDao cardOverrideDao() {
        return this._cardOverrideDao.getValue();
    }

    @Override // com.example.flashcardapp.data.AppDatabase
    public CardAttemptDao cardAttemptDao() {
        return this._cardAttemptDao.getValue();
    }

    @Override // com.example.flashcardapp.data.AppDatabase
    public CardStateDao cardStateDao() {
        return this._cardStateDao.getValue();
    }

    @Override // com.example.flashcardapp.data.AppDatabase
    public AliasDao aliasDao() {
        return this._aliasDao.getValue();
    }

    @Override // com.example.flashcardapp.data.AppDatabase
    public CardUserMetadataDao cardUserMetadataDao() {
        return this._cardUserMetadataDao.getValue();
    }

    @Override // com.example.flashcardapp.data.AppDatabase
    public DeckProgressLedgerDao deckProgressLedgerDao() {
        return this._deckProgressLedgerDao.getValue();
    }
}
