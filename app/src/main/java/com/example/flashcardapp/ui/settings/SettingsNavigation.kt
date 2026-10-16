package com.example.flashcardapp.ui.settings

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * High-level categories displayed on the Root Settings Screen.
 */
enum class SettingsCategory(
    val title: String,
    val subtitle: String,
    val icon: ImageVector
) {
    APPEARANCE(
        title = "Visuals & Theming",
        subtitle = "Theme palettes, dark mode, OLED black, custom fonts & scaling",
        icon = Icons.Outlined.Palette
    ),
    STUDY_PREFERENCES(
        title = "Quiz & Study Preferences",
        subtitle = "Session modes, question limits, timers, FSRS scheduling & scoring",
        icon = Icons.Outlined.Psychology
    ),
    BACKUP_SYNC(
        title = "Backup & Synchronization",
        subtitle = "AnkiDroid integration, automated SAF backups, manual export/import",
        icon = Icons.Outlined.CloudSync
    ),
    EXTENSIONS(
        title = "Plugins & Extensions",
        subtitle = "Web scraping importer, dynamic JS plugins & Current Affairs",
        icon = Icons.Outlined.Extension
    ),
    LANGUAGE_TRANSLATIONS(
        title = "Language & Localization",
        subtitle = "App language, translation cache & tactile haptic vibration",
        icon = Icons.Outlined.Translate
    ),
    STORAGE(
        title = "Storage & Database",
        subtitle = "Deck & card stats, cache cleaner, media cleanup & file importers",
        icon = Icons.Outlined.Storage
    ),
    WHITEBOARD(
        title = "Whiteboard & Stylus Engine",
        subtitle = "Stylus detection, highlighter alpha, gesture shortcuts & toolbar docking",
        icon = Icons.Outlined.Draw
    ),
    PROFILE(
        title = "Profile & Targets",
        subtitle = "Exam goals, target dates, revision alarms & user profile",
        icon = Icons.Outlined.Person
    ),
    INSTRUCTIONS(
        title = "File Format Guides",
        subtitle = "CSV, APKG, EPUB, and PDF parsing specs & sample formats",
        icon = Icons.Outlined.HelpOutline
    )
}

/**
 * Mid-level sub-headings grouping specific leaf controls.
 */
enum class SettingsSubCategory(
    val parentCategory: SettingsCategory,
    val title: String,
    val subtitle: String,
    val icon: ImageVector
) {
    // Appearance
    THEME_SELECTION(
        SettingsCategory.APPEARANCE,
        "Color Themes & Palettes",
        "Select curated color schemes and accents",
        Icons.Outlined.ColorLens
    ),
    DARK_MODE(
        SettingsCategory.APPEARANCE,
        "Dark & OLED Mode",
        "Deep contrast, true black OLED, and dynamic wallpaper",
        Icons.Outlined.DarkMode
    ),
    TYPOGRAPHY_FONTS(
        SettingsCategory.APPEARANCE,
        "Typography & Font Sizing",
        "Atkinson Hyperlegible, custom OTF/TTF fonts, and text scaling",
        Icons.Outlined.TextFields
    ),

    // Study Preferences
    SESSION_RULES(
        SettingsCategory.STUDY_PREFERENCES,
        "Session Modes & Layout",
        "Flashcard, MCQ, Quick Study, options count, and shuffle",
        Icons.Outlined.Tune
    ),
    SCORING_TIMERS(
        SettingsCategory.STUDY_PREFERENCES,
        "Time Limits & Explanations",
        "Per-question countdown, automatic explanations, and scoring marks",
        Icons.Outlined.Timer
    ),
    ALGORITHM_SCHEDULING(
        SettingsCategory.STUDY_PREFERENCES,
        "Spaced Repetition Algorithm",
        "FSRS-4.5 vs classic SM-2 scheduling parameters",
        Icons.Outlined.AutoGraph
    ),

    // Backup & Sync
    ANKIDROID_SYNC(
        SettingsCategory.BACKUP_SYNC,
        "AnkiDroid Sync",
        "Bidirectional sync with AnkiDroid storage provider",
        Icons.Outlined.Sync
    ),
    AUTO_BACKUP_SAF(
        SettingsCategory.BACKUP_SYNC,
        "Automated SAF Backups",
        "Scheduled SQLite exports to Android document tree",
        Icons.Outlined.FolderZip
    ),
    MANUAL_BACKUP_RESTORE(
        SettingsCategory.BACKUP_SYNC,
        "Manual Backup & Restore",
        "Create an immediate .db snapshot or restore from external file",
        Icons.Outlined.SettingsBackupRestore
    ),

    // Extensions
    WEB_SCRAPING(
        SettingsCategory.EXTENSIONS,
        "Web Scrape Importer",
        "Extract flashcards from live web pages via selectors",
        Icons.Outlined.Language
    ),
    PLUGINS(
        SettingsCategory.EXTENSIONS,
        "Plugin Manager",
        "Load external JavaScript extensions and scrapers",
        Icons.Outlined.Extension
    ),
    CURRENT_AFFAIRS(
        SettingsCategory.EXTENSIONS,
        "Current Affairs Portal",
        "Configure RSS sources and daily exam news updates",
        Icons.Outlined.Newspaper
    ),

    // Language & Translations
    APP_LANGUAGE(
        SettingsCategory.LANGUAGE_TRANSLATIONS,
        "Interface Language",
        "Switch language across English, Hindi, and regional dialects",
        Icons.Outlined.Language
    ),
    HAPTICS_FEEDBACK(
        SettingsCategory.LANGUAGE_TRANSLATIONS,
        "Haptics & Vibration",
        "Tactile vibration feedback on button press and answer reveal",
        Icons.Outlined.Vibration
    ),

    // Storage
    DATABASE_STATS(
        SettingsCategory.STORAGE,
        "Database Statistics",
        "Total decks, cards, media size, and storage usage",
        Icons.Outlined.DataUsage
    ),
    IMPORT_EXPORT(
        SettingsCategory.STORAGE,
        "Import & Export Decks",
        "Import APKG, CSV, EPUB, PDF or export decks to APKG",
        Icons.Outlined.ImportExport
    ),
    CACHE_MANAGEMENT(
        SettingsCategory.STORAGE,
        "Cache & Cleanup",
        "Wipe temporary web cache and toggle orphan media cleanup",
        Icons.Outlined.CleaningServices
    ),

    // Whiteboard
    STYLUS_ENGINE(
        SettingsCategory.WHITEBOARD,
        "Stylus & Pen Physics",
        "Auto-stylus mode, pen colors, and highlighter transparency",
        Icons.Outlined.Brush
    ),
    GESTURES_TOUCH(
        SettingsCategory.WHITEBOARD,
        "Touch & Palm Rejection",
        "Multi-touch gestures, two-finger undo, and toolbar docking",
        Icons.Outlined.TouchApp
    ),

    // Profile
    PROFILE_DETAILS(
        SettingsCategory.PROFILE,
        "User Identity",
        "Avatar picture, username, and bio",
        Icons.Outlined.AccountCircle
    ),
    STUDY_TARGETS(
        SettingsCategory.PROFILE,
        "Exam Target & Goals",
        "Select target competitive exam and countdown target date",
        Icons.Outlined.Flag
    ),
    DAILY_REMINDER(
        SettingsCategory.PROFILE,
        "Daily Study Reminders",
        "Configure daily push notifications and study alarms",
        Icons.Outlined.NotificationsActive
    ),

    // Instructions
    FORMAT_SPECIFICATIONS(
        SettingsCategory.INSTRUCTIONS,
        "Format Specs & Examples",
        "Sample templates for CSV, APKG, EPUB, and PDF imports",
        Icons.Outlined.Description
    )
}

/**
 * Sealed destination representing the current view within the Settings back stack.
 */
sealed interface SettingsRoute {
    object Root : SettingsRoute
    data class Category(val category: SettingsCategory) : SettingsRoute
    data class SubCategory(val category: SettingsCategory, val subCategory: SettingsSubCategory) : SettingsRoute
}
