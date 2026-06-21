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
import com.example.flashcardapp.data.entities.CardStateEntity
import com.example.flashcardapp.data.entities.CardOverrideEntity
import com.example.flashcardapp.data.entities.CardEntity
import com.example.flashcardapp.data.entities.DeckEntity
import com.example.flashcardapp.data.entities.SessionRecordEntity
import com.example.flashcardapp.data.entities.CardAttemptEntity
import com.example.flashcardapp.data.entities.AliasEntity

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
        AliasEntity::class
    ],
    version = 9,
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

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                )
                    .addMigrations(MIGRATION_4_5, MIGRATION_5_6, MIGRATION_6_7, MIGRATION_7_8, MIGRATION_8_9)
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}
