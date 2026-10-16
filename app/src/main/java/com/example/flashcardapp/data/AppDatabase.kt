package com.example.flashcardapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.flashcardapp.data.dao.CardDao
import com.example.flashcardapp.data.dao.DeckDao
import com.example.flashcardapp.data.dao.SessionRecordDao
import com.example.flashcardapp.data.dao.CardOverrideDao
import com.example.flashcardapp.data.dao.CardAttemptDao
import com.example.flashcardapp.data.dao.CardStateDao
import com.example.flashcardapp.data.dao.AliasDao
import com.example.flashcardapp.data.dao.CardUserMetadataDao
import com.example.flashcardapp.data.entities.CardStateEntity
import com.example.flashcardapp.data.entities.CardOverrideEntity
import com.example.flashcardapp.data.entities.CardEntity
import com.example.flashcardapp.data.entities.DeckEntity
import com.example.flashcardapp.data.entities.SessionRecordEntity
import com.example.flashcardapp.data.entities.CardAttemptEntity
import com.example.flashcardapp.data.entities.AliasEntity
import com.example.flashcardapp.data.entities.CardUserMetadataEntity
import com.example.flashcardapp.data.entities.DeckProgressLedger
import com.example.flashcardapp.data.dao.DeckProgressLedgerDao

import com.example.flashcardapp.data.dao.QuestionDao
import com.example.flashcardapp.data.entities.QuestionEntity

import com.example.flashcardapp.data.dao.PluginDao
import com.example.flashcardapp.data.entities.PluginEntity

import com.example.flashcardapp.data.dao.CurrentAffairsSourceDao
import com.example.flashcardapp.data.entities.CurrentAffairsSourceEntity

/**
 * Room database for caching AnkiDroid flashcard data locally.
 *
 * This is the single source of truth for all card data in the app.
 * AnkiDroid content provider data is synced here and all consumers
 * read from this database — never directly from the content provider.
 *
 * Uses a thread-safe singleton pattern via [getInstance].
 */
@Database(
    entities = [
        DeckEntity::class,
        CardEntity::class,
        SessionRecordEntity::class,
        CardOverrideEntity::class,
        CardAttemptEntity::class,
        CardStateEntity::class,
        AliasEntity::class,
        CardUserMetadataEntity::class,
        DeckProgressLedger::class,
        QuestionEntity::class,
        PluginEntity::class,
        CurrentAffairsSourceEntity::class
    ],
    version = 16,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun deckDao(): DeckDao
    abstract fun cardDao(): CardDao
    abstract fun sessionRecordDao(): SessionRecordDao
    abstract fun cardOverrideDao(): CardOverrideDao
    abstract fun cardAttemptDao(): CardAttemptDao
    abstract fun cardStateDao(): CardStateDao
    abstract fun aliasDao(): AliasDao
    abstract fun cardUserMetadataDao(): CardUserMetadataDao
    abstract fun deckProgressLedgerDao(): DeckProgressLedgerDao
    abstract fun questionDao(): QuestionDao
    abstract fun pluginDao(): PluginDao
    abstract fun currentAffairsSourceDao(): CurrentAffairsSourceDao

    companion object {
        private const val DATABASE_NAME = "ankiprep_cache.db"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        val MIGRATION_4_5 = object : androidx.room.migration.Migration(4, 5) {
            override fun migrate(db: androidx.sqlite.db.SupportSQLiteDatabase) {
                // Add columns to card_attempts
                db.execSQL("ALTER TABLE `card_attempts` ADD COLUMN `timeTakenMs` INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE `card_attempts` ADD COLUMN `fsrsRating` INTEGER NOT NULL DEFAULT 0")
                
                // Create table card_states
                db.execSQL("""
                    CREATE TABLE IF NOT EXISTS `card_states` (
                        `cardId` INTEGER NOT NULL, 
                        `stability` REAL NOT NULL, 
                        `difficulty` REAL NOT NULL, 
                        `interval` INTEGER NOT NULL, 
                        `dueDate` INTEGER NOT NULL, 
                        `lastReview` INTEGER NOT NULL, 
                        `reviewCount` INTEGER NOT NULL, 
                        `lapses` INTEGER NOT NULL, 
                        `state` INTEGER NOT NULL, 
                        PRIMARY KEY(`cardId`), 
                        FOREIGN KEY(`cardId`) REFERENCES `cards`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE 
                    )
                """.trimIndent())
                
                // Indices for card_states
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_card_states_cardId` ON `card_states` (`cardId`)")
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_card_states_dueDate` ON `card_states` (`dueDate`)")
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_card_states_state` ON `card_states` (`state`)")
            }
        }

        val MIGRATION_5_6 = object : androidx.room.migration.Migration(5, 6) {
            override fun migrate(db: androidx.sqlite.db.SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE `card_overrides` ADD COLUMN `tagsOverride` TEXT")
            }
        }

        val MIGRATION_6_7 = object : androidx.room.migration.Migration(6, 7) {
            override fun migrate(db: androidx.sqlite.db.SupportSQLiteDatabase) {
                db.execSQL("CREATE TABLE IF NOT EXISTS `aliases` (`name` TEXT NOT NULL, `alias` TEXT NOT NULL, PRIMARY KEY(`name`, `alias`))")
            }
        }

        val MIGRATION_7_8 = object : androidx.room.migration.Migration(7, 8) {
            override fun migrate(db: androidx.sqlite.db.SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE `cards` ADD COLUMN `frontImage` TEXT")
                db.execSQL("ALTER TABLE `cards` ADD COLUMN `backImage` TEXT")
                db.execSQL("ALTER TABLE `cards` ADD COLUMN `explanationImage` TEXT")
                db.execSQL("ALTER TABLE `cards` ADD COLUMN `optionImagesJson` TEXT")
                
                db.execSQL("ALTER TABLE `card_overrides` ADD COLUMN `frontImageOverride` TEXT")
                db.execSQL("ALTER TABLE `card_overrides` ADD COLUMN `backImageOverride` TEXT")
                db.execSQL("ALTER TABLE `card_overrides` ADD COLUMN `explanationImageOverride` TEXT")
                db.execSQL("ALTER TABLE `card_overrides` ADD COLUMN `optionImagesOverrideJson` TEXT")
            }
        }

        val MIGRATION_8_9 = object : androidx.room.migration.Migration(8, 9) {
            override fun migrate(db: androidx.sqlite.db.SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE `card_states` ADD COLUMN `retrievability` REAL NOT NULL DEFAULT 0.0")
                db.execSQL("ALTER TABLE `card_states` ADD COLUMN `retrievabilityTimestamp` INTEGER NOT NULL DEFAULT 0")
            }
        }

        val MIGRATION_9_10 = object : androidx.room.migration.Migration(9, 10) {
            override fun migrate(db: androidx.sqlite.db.SupportSQLiteDatabase) {
                db.execSQL("""
                    CREATE TABLE IF NOT EXISTS `card_user_metadata` (
                        `cardId` INTEGER NOT NULL, 
                        `isStarred` INTEGER NOT NULL DEFAULT 0, 
                        `rating` INTEGER NOT NULL DEFAULT 0, 
                        PRIMARY KEY(`cardId`), 
                        FOREIGN KEY(`cardId`) REFERENCES `cards`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE 
                    )
                """.trimIndent())
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_card_user_metadata_cardId` ON `card_user_metadata` (`cardId`)")
            }
        }

        val MIGRATION_10_11 = object : androidx.room.migration.Migration(10, 11) {
            override fun migrate(db: androidx.sqlite.db.SupportSQLiteDatabase) {
                db.execSQL("""
                    CREATE TABLE IF NOT EXISTS `DeckProgressLedger` (
                        `cardId` INTEGER NOT NULL, 
                        `deckId` INTEGER NOT NULL, 
                        PRIMARY KEY(`cardId`), 
                        FOREIGN KEY(`cardId`) REFERENCES `cards`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE 
                    )
                """.trimIndent())
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_DeckProgressLedger_cardId` ON `DeckProgressLedger` (`cardId`)")
            }
        }

        val MIGRATION_11_12 = object : androidx.room.migration.Migration(11, 12) {
            override fun migrate(db: androidx.sqlite.db.SupportSQLiteDatabase) {
                // Ensure the index exists for card_user_metadata — may have been missed on some devices
                db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_card_user_metadata_cardId` ON `card_user_metadata` (`cardId`)")
            }
        }

        val MIGRATION_12_13 = object : androidx.room.migration.Migration(12, 13) {
            override fun migrate(db: androidx.sqlite.db.SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE `decks` ADD COLUMN `sortOrder` INTEGER NOT NULL DEFAULT 0")
            }
        }

        val MIGRATION_13_14 = object : androidx.room.migration.Migration(13, 14) {
            override fun migrate(db: androidx.sqlite.db.SupportSQLiteDatabase) {
                db.execSQL("""
                    CREATE TABLE IF NOT EXISTS `pyq_questions` (
                        `id` TEXT NOT NULL, 
                        `questionText` TEXT NOT NULL, 
                        `optionA` TEXT NOT NULL, 
                        `optionB` TEXT NOT NULL, 
                        `optionC` TEXT NOT NULL, 
                        `optionD` TEXT NOT NULL, 
                        `correctAnswer` TEXT NOT NULL, 
                        `explanation` TEXT NOT NULL, 
                        `subject` TEXT NOT NULL, 
                        `subTopic` TEXT NOT NULL, 
                        `examRawTag` TEXT NOT NULL, 
                        `examName` TEXT NOT NULL, 
                        `examYear` INTEGER NOT NULL, 
                        `tagsJson` TEXT NOT NULL, 
                        `timestamp` INTEGER NOT NULL, 
                        PRIMARY KEY(`id`)
                    )
                """.trimIndent())
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_pyq_questions_subject` ON `pyq_questions` (`subject`)")
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_pyq_questions_subTopic` ON `pyq_questions` (`subTopic`)")
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_pyq_questions_examYear` ON `pyq_questions` (`examYear`)")
            }
        }

        val MIGRATION_14_15 = object : androidx.room.migration.Migration(14, 15) {
            override fun migrate(db: androidx.sqlite.db.SupportSQLiteDatabase) {
                db.execSQL("""
                    CREATE TABLE IF NOT EXISTS `plugins` (
                        `id` TEXT NOT NULL, 
                        `name` TEXT NOT NULL, 
                        `version` TEXT NOT NULL, 
                        `author` TEXT NOT NULL, 
                        `inputType` TEXT NOT NULL, 
                        `description` TEXT NOT NULL, 
                        `scriptContent` TEXT NOT NULL, 
                        `isEnabled` INTEGER NOT NULL, 
                        `installedAt` INTEGER NOT NULL, 
                        PRIMARY KEY(`id`)
                    )
                """.trimIndent())
            }
        }

        val MIGRATION_15_16 = object : androidx.room.migration.Migration(15, 16) {
            override fun migrate(db: androidx.sqlite.db.SupportSQLiteDatabase) {
                db.execSQL("""
                    CREATE TABLE IF NOT EXISTS `current_affairs_sources` (
                        `id` TEXT NOT NULL, 
                        `title` TEXT NOT NULL, 
                        `feedUrl` TEXT NOT NULL, 
                        `isActive` INTEGER NOT NULL, 
                        `addedTimestamp` INTEGER NOT NULL, 
                        PRIMARY KEY(`id`)
                    )
                """.trimIndent())
            }
        }

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                )
                    .addMigrations(
                        MIGRATION_4_5, MIGRATION_5_6, MIGRATION_6_7, MIGRATION_7_8, MIGRATION_8_9, 
                        MIGRATION_9_10, MIGRATION_10_11, MIGRATION_11_12, MIGRATION_12_13, MIGRATION_13_14,
                        MIGRATION_14_15, MIGRATION_15_16
                    )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }

        fun closeInstance() {
            synchronized(this) {
                INSTANCE?.close()
                INSTANCE = null
            }
        }
    }
}
