package com.example.flashcardapp.data;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.example.flashcardapp.data.dao.AliasDao;
import com.example.flashcardapp.data.dao.CardAttemptDao;
import com.example.flashcardapp.data.dao.CardDao;
import com.example.flashcardapp.data.dao.CardOverrideDao;
import com.example.flashcardapp.data.dao.CardStateDao;
import com.example.flashcardapp.data.dao.CardUserMetadataDao;
import com.example.flashcardapp.data.dao.DeckDao;
import com.example.flashcardapp.data.dao.DeckProgressLedgerDao;
import com.example.flashcardapp.data.dao.SessionRecordDao;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppDatabase.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H&¨\u0006\u0016"}, d2 = {"Lcom/example/flashcardapp/data/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "aliasDao", "Lcom/example/flashcardapp/data/dao/AliasDao;", "cardAttemptDao", "Lcom/example/flashcardapp/data/dao/CardAttemptDao;", "cardDao", "Lcom/example/flashcardapp/data/dao/CardDao;", "cardOverrideDao", "Lcom/example/flashcardapp/data/dao/CardOverrideDao;", "cardStateDao", "Lcom/example/flashcardapp/data/dao/CardStateDao;", "cardUserMetadataDao", "Lcom/example/flashcardapp/data/dao/CardUserMetadataDao;", "deckDao", "Lcom/example/flashcardapp/data/dao/DeckDao;", "deckProgressLedgerDao", "Lcom/example/flashcardapp/data/dao/DeckProgressLedgerDao;", "sessionRecordDao", "Lcom/example/flashcardapp/data/dao/SessionRecordDao;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public abstract class AppDatabase extends RoomDatabase {
    public static final int $stable = 0;
    private static final String DATABASE_NAME = "ankiprep_cache.db";
    private static volatile AppDatabase INSTANCE;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Migration MIGRATION_4_5 = new Migration() { // from class: com.example.flashcardapp.data.AppDatabase$Companion$MIGRATION_4_5$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("ALTER TABLE `card_attempts` ADD COLUMN `timeTakenMs` INTEGER NOT NULL DEFAULT 0");
            db.execSQL("ALTER TABLE `card_attempts` ADD COLUMN `fsrsRating` INTEGER NOT NULL DEFAULT 0");
            db.execSQL("CREATE TABLE IF NOT EXISTS `card_states` (\n    `cardId` INTEGER NOT NULL, \n    `stability` REAL NOT NULL, \n    `difficulty` REAL NOT NULL, \n    `interval` INTEGER NOT NULL, \n    `dueDate` INTEGER NOT NULL, \n    `lastReview` INTEGER NOT NULL, \n    `reviewCount` INTEGER NOT NULL, \n    `lapses` INTEGER NOT NULL, \n    `state` INTEGER NOT NULL, \n    PRIMARY KEY(`cardId`), \n    FOREIGN KEY(`cardId`) REFERENCES `cards`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE \n)");
            db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_card_states_cardId` ON `card_states` (`cardId`)");
            db.execSQL("CREATE INDEX IF NOT EXISTS `index_card_states_dueDate` ON `card_states` (`dueDate`)");
            db.execSQL("CREATE INDEX IF NOT EXISTS `index_card_states_state` ON `card_states` (`state`)");
        }
    };
    private static final Migration MIGRATION_5_6 = new Migration() { // from class: com.example.flashcardapp.data.AppDatabase$Companion$MIGRATION_5_6$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("ALTER TABLE `card_overrides` ADD COLUMN `tagsOverride` TEXT");
        }
    };
    private static final Migration MIGRATION_6_7 = new Migration() { // from class: com.example.flashcardapp.data.AppDatabase$Companion$MIGRATION_6_7$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("CREATE TABLE IF NOT EXISTS `aliases` (`name` TEXT NOT NULL, `alias` TEXT NOT NULL, PRIMARY KEY(`name`, `alias`))");
        }
    };
    private static final Migration MIGRATION_7_8 = new Migration() { // from class: com.example.flashcardapp.data.AppDatabase$Companion$MIGRATION_7_8$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("ALTER TABLE `cards` ADD COLUMN `frontImage` TEXT");
            db.execSQL("ALTER TABLE `cards` ADD COLUMN `backImage` TEXT");
            db.execSQL("ALTER TABLE `cards` ADD COLUMN `explanationImage` TEXT");
            db.execSQL("ALTER TABLE `cards` ADD COLUMN `optionImagesJson` TEXT");
            db.execSQL("ALTER TABLE `card_overrides` ADD COLUMN `frontImageOverride` TEXT");
            db.execSQL("ALTER TABLE `card_overrides` ADD COLUMN `backImageOverride` TEXT");
            db.execSQL("ALTER TABLE `card_overrides` ADD COLUMN `explanationImageOverride` TEXT");
            db.execSQL("ALTER TABLE `card_overrides` ADD COLUMN `optionImagesOverrideJson` TEXT");
        }
    };
    private static final Migration MIGRATION_8_9 = new Migration() { // from class: com.example.flashcardapp.data.AppDatabase$Companion$MIGRATION_8_9$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("ALTER TABLE `card_states` ADD COLUMN `retrievability` REAL NOT NULL DEFAULT 0.0");
            db.execSQL("ALTER TABLE `card_states` ADD COLUMN `retrievabilityTimestamp` INTEGER NOT NULL DEFAULT 0");
        }
    };
    private static final Migration MIGRATION_9_10 = new Migration() { // from class: com.example.flashcardapp.data.AppDatabase$Companion$MIGRATION_9_10$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("CREATE TABLE IF NOT EXISTS `card_user_metadata` (\n    `cardId` INTEGER NOT NULL, \n    `isStarred` INTEGER NOT NULL DEFAULT 0, \n    `rating` INTEGER NOT NULL DEFAULT 0, \n    PRIMARY KEY(`cardId`), \n    FOREIGN KEY(`cardId`) REFERENCES `cards`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE \n)");
            db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_card_user_metadata_cardId` ON `card_user_metadata` (`cardId`)");
        }
    };
    private static final Migration MIGRATION_10_11 = new Migration() { // from class: com.example.flashcardapp.data.AppDatabase$Companion$MIGRATION_10_11$1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            db.execSQL("CREATE TABLE IF NOT EXISTS `DeckProgressLedger` (\n    `cardId` INTEGER NOT NULL, \n    `deckId` INTEGER NOT NULL, \n    PRIMARY KEY(`cardId`), \n    FOREIGN KEY(`cardId`) REFERENCES `cards`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE \n)");
            db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_DeckProgressLedger_cardId` ON `DeckProgressLedger` (`cardId`)");
        }
    };

    public abstract AliasDao aliasDao();

    public abstract CardAttemptDao cardAttemptDao();

    public abstract CardDao cardDao();

    public abstract CardOverrideDao cardOverrideDao();

    public abstract CardStateDao cardStateDao();

    public abstract CardUserMetadataDao cardUserMetadataDao();

    public abstract DeckDao deckDao();

    public abstract DeckProgressLedgerDao deckProgressLedgerDao();

    public abstract SessionRecordDao sessionRecordDao();

    /* compiled from: AppDatabase.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0011\u0010\u000f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0011\u0010\u0011\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0011\u0010\u0013\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u0011\u0010\u0015\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/example/flashcardapp/data/AppDatabase$Companion;", "", "()V", "DATABASE_NAME", "", "INSTANCE", "Lcom/example/flashcardapp/data/AppDatabase;", "MIGRATION_10_11", "Landroidx/room/migration/Migration;", "getMIGRATION_10_11", "()Landroidx/room/migration/Migration;", "MIGRATION_4_5", "getMIGRATION_4_5", "MIGRATION_5_6", "getMIGRATION_5_6", "MIGRATION_6_7", "getMIGRATION_6_7", "MIGRATION_7_8", "getMIGRATION_7_8", "MIGRATION_8_9", "getMIGRATION_8_9", "MIGRATION_9_10", "getMIGRATION_9_10", "getInstance", "context", "Landroid/content/Context;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Migration getMIGRATION_4_5() {
            return AppDatabase.MIGRATION_4_5;
        }

        public final Migration getMIGRATION_5_6() {
            return AppDatabase.MIGRATION_5_6;
        }

        public final Migration getMIGRATION_6_7() {
            return AppDatabase.MIGRATION_6_7;
        }

        public final Migration getMIGRATION_7_8() {
            return AppDatabase.MIGRATION_7_8;
        }

        public final Migration getMIGRATION_8_9() {
            return AppDatabase.MIGRATION_8_9;
        }

        public final Migration getMIGRATION_9_10() {
            return AppDatabase.MIGRATION_9_10;
        }

        public final Migration getMIGRATION_10_11() {
            return AppDatabase.MIGRATION_10_11;
        }

        public final AppDatabase getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            AppDatabase appDatabase = AppDatabase.INSTANCE;
            if (appDatabase == null) {
                synchronized (this) {
                    appDatabase = AppDatabase.INSTANCE;
                    if (appDatabase == null) {
                        Context applicationContext = context.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                        RoomDatabase build = Room.databaseBuilder(applicationContext, AppDatabase.class, AppDatabase.DATABASE_NAME).addMigrations(AppDatabase.INSTANCE.getMIGRATION_4_5(), AppDatabase.INSTANCE.getMIGRATION_5_6(), AppDatabase.INSTANCE.getMIGRATION_6_7(), AppDatabase.INSTANCE.getMIGRATION_7_8(), AppDatabase.INSTANCE.getMIGRATION_8_9(), AppDatabase.INSTANCE.getMIGRATION_9_10(), AppDatabase.INSTANCE.getMIGRATION_10_11()).fallbackToDestructiveMigration().build();
                        Companion companion = AppDatabase.INSTANCE;
                        AppDatabase.INSTANCE = (AppDatabase) build;
                        appDatabase = (AppDatabase) build;
                    }
                }
            }
            return appDatabase;
        }
    }
}
