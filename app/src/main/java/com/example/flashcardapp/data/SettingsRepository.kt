package com.example.flashcardapp.data

import android.content.Context
import android.content.SharedPreferences
import com.example.flashcardapp.session.McqSessionMode

/**
 * Manages persistent configuration and preferences for the application.
 */
class SettingsRepository private constructor(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("ankiprep_settings", Context.MODE_PRIVATE)

    init {
        val savedLang = prefs.getString("app_language", "en") ?: "en"
        TranslationManager.setLanguageByCode(savedLang)
    }


    companion object {
        @Volatile
        private var INSTANCE: SettingsRepository? = null

        fun getInstance(context: Context): SettingsRepository {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: SettingsRepository(context.applicationContext).also { INSTANCE = it }
            }
        }
    }

    var studyMode: McqSessionMode
        get() = try {
            val name = prefs.getString("study_mode", McqSessionMode.PRACTICE.name) ?: McqSessionMode.PRACTICE.name
            McqSessionMode.valueOf(name)
        } catch (e: Exception) {
            McqSessionMode.PRACTICE
        }
        set(value) = prefs.edit().putString("study_mode", value.name).apply()

    var isPremium: Boolean
        get() = prefs.getBoolean("is_premium", false)
        set(value) = prefs.edit().putBoolean("is_premium", value).apply()

    var vibrationEnabled: Boolean
        get() = prefs.getBoolean("vibration_enabled", true)
        set(value) = prefs.edit().putBoolean("vibration_enabled", value).apply()

    var questionLimit: Int
        get() = prefs.getInt("question_limit", 20) // Default: 20 questions
        set(value) = prefs.edit().putInt("question_limit", value).apply()

    var shuffleQuestions: Boolean
        get() = prefs.getBoolean("shuffle_questions", true)
        set(value) = prefs.edit().putBoolean("shuffle_questions", value).apply()

    var numberOfOptions: Int
        get() = prefs.getInt("number_of_options", 4) // Default: 4 options (A, B, C, D)
        set(value) = prefs.edit().putInt("number_of_options", value).apply()

    var showExplanations: Boolean
        get() = prefs.getBoolean("show_explanations", true)
        set(value) = prefs.edit().putBoolean("show_explanations", value).apply()

    var showTags: Boolean
        get() = prefs.getBoolean("show_tags", true)
        set(value) = prefs.edit().putBoolean("show_tags", value).apply()

    var timeLimitSeconds: Int
        get() = prefs.getInt("time_limit_seconds", 0) // Default: 0 (Unlimited)
        set(value) = prefs.edit().putInt("time_limit_seconds", value).apply()

    var themePreset: String
        get() = prefs.getString("theme_preset", "EMERALD") ?: "EMERALD"
        set(value) = prefs.edit().putString("theme_preset", value).apply()

    var useDynamicWallpaperTheme: Boolean
        get() = prefs.getBoolean("use_dynamic_wallpaper_theme", false)
        set(value) = prefs.edit().putBoolean("use_dynamic_wallpaper_theme", value).apply()

    var fontFamilyType: String
        get() = prefs.getString("font_family_type", "DEFAULT") ?: "DEFAULT"
        set(value) = prefs.edit().putString("font_family_type", value).apply()

    var customFontPath: String?
        get() = prefs.getString("custom_font_path", null)
        set(value) = prefs.edit().putString("custom_font_path", value).apply()

    var isDarkMode: Boolean
        get() = prefs.getBoolean("is_dark_mode", false)
        set(value) = prefs.edit().putBoolean("is_dark_mode", value).apply()

    var appLanguage: String
        get() = prefs.getString("app_language", "en") ?: "en"
        set(value) {
            prefs.edit().putString("app_language", value).apply()
            TranslationManager.setLanguageByCode(value)
        }

    var userName: String
        get() = prefs.getString("user_name", "") ?: ""
        set(value) = prefs.edit().putString("user_name", value).apply()

    var userEmail: String
        get() = prefs.getString("user_email", "") ?: ""
        set(value) = prefs.edit().putString("user_email", value).apply()

    var userTarget: String
        get() = prefs.getString("user_target", "") ?: ""
        set(value) = prefs.edit().putString("user_target", value).apply()

    // Deck-Specific Overrides
    fun getPreferredModeForDeck(deckId: Long): McqSessionMode? {
        val name = prefs.getString("deck_${deckId}_preferred_mode", null) ?: return null
        return try { McqSessionMode.valueOf(name) } catch(e: Exception) { null }
    }
    fun setPreferredModeForDeck(deckId: Long, mode: McqSessionMode?) {
        if (mode == null) {
            prefs.edit().remove("deck_${deckId}_preferred_mode").apply()
        } else {
            prefs.edit().putString("deck_${deckId}_preferred_mode", mode.name).apply()
        }
    }

    fun getQuestionLimitForDeck(deckId: Long): Int? {
        if (!prefs.contains("deck_${deckId}_question_limit")) return null
        return prefs.getInt("deck_${deckId}_question_limit", 0)
    }
    fun setQuestionLimitForDeck(deckId: Long, limit: Int?) {
        if (limit == null) {
            prefs.edit().remove("deck_${deckId}_question_limit").apply()
        } else {
            prefs.edit().putInt("deck_${deckId}_question_limit", limit).apply()
        }
    }

    fun getTimeLimitSecondsForDeck(deckId: Long): Int? {
        if (!prefs.contains("deck_${deckId}_time_limit_seconds")) return null
        return prefs.getInt("deck_${deckId}_time_limit_seconds", 0)
    }
    fun setTimeLimitSecondsForDeck(deckId: Long, timeLimit: Int?) {
        if (timeLimit == null) {
            prefs.edit().remove("deck_${deckId}_time_limit_seconds").apply()
        } else {
            prefs.edit().putInt("deck_${deckId}_time_limit_seconds", timeLimit).apply()
        }
    }

    fun getPositiveMarksForDeck(deckId: Long): Float? {
        if (!prefs.contains("deck_${deckId}_positive_marks")) return null
        return prefs.getFloat("deck_${deckId}_positive_marks", 1.0f)
    }
    fun setPositiveMarksForDeck(deckId: Long, marks: Float?) {
        if (marks == null) {
            prefs.edit().remove("deck_${deckId}_positive_marks").apply()
        } else {
            prefs.edit().putFloat("deck_${deckId}_positive_marks", marks).apply()
        }
    }

    fun getNegativeMarksForDeck(deckId: Long): Float? {
        if (!prefs.contains("deck_${deckId}_negative_marks")) return null
        return prefs.getFloat("deck_${deckId}_negative_marks", 0.0f)
    }
    fun setNegativeMarksForDeck(deckId: Long, marks: Float?) {
        if (marks == null) {
            prefs.edit().remove("deck_${deckId}_negative_marks").apply()
        } else {
            prefs.edit().putFloat("deck_${deckId}_negative_marks", marks).apply()
        }
    }

    var userProfileImageUri: String
        get() = prefs.getString("user_profile_image_uri", "") ?: ""
        set(value) = prefs.edit().putString("user_profile_image_uri", value).apply()

    var userDateOfBirth: String
        get() = prefs.getString("user_date_of_birth", "") ?: ""
        set(value) = prefs.edit().putString("user_date_of_birth", value).apply()

    var userImportantDatesJson: String
        get() = prefs.getString("user_important_dates_json", "[]") ?: "[]"
        set(value) = prefs.edit().putString("user_important_dates_json", value).apply()

    var reminderEnabled: Boolean
        get() = prefs.getBoolean("reminder_enabled", false)
        set(value) = prefs.edit().putBoolean("reminder_enabled", value).apply()

    var reminderHour: Int
        get() = prefs.getInt("reminder_hour", 20)
        set(value) = prefs.edit().putInt("reminder_hour", value).apply()

    var reminderMinute: Int
        get() = prefs.getInt("reminder_minute", 0)
        set(value) = prefs.edit().putInt("reminder_minute", value).apply()

    var reminderDays: Set<String>
        get() = prefs.getStringSet("reminder_days", setOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")) ?: setOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
        set(value) = prefs.edit().putStringSet("reminder_days", value).apply()

    var deleteImagesOnCardDelete: Boolean
        get() = prefs.getBoolean("delete_images_on_card_delete", true)
        set(value) = prefs.edit().putBoolean("delete_images_on_card_delete", value).apply()

    var defaultAlgorithm: String
        get() = prefs.getString("default_algorithm", "FSRS") ?: "FSRS"
        set(value) = prefs.edit().putString("default_algorithm", value).apply()

    fun getDeckOrderList(): List<Long> {
        val json = prefs.getString("deck_order_json", "[]") ?: "[]"
        return try {
            json.removeSurrounding("[", "]")
                .split(",")
                .mapNotNull { it.trim().toLongOrNull() }
        } catch (e: Exception) {
            emptyList()
        }
    }

    fun setDeckOrderList(list: List<Long>) {
        prefs.edit().putString("deck_order_json", list.toString()).apply()
    }

    fun moveDeckUp(deckId: Long, allDeckIds: List<Long>) {
        val currentOrder = getDeckOrderList().toMutableList()
        allDeckIds.forEach { id ->
            if (!currentOrder.contains(id)) {
                currentOrder.add(id)
            }
        }
        val index = currentOrder.indexOf(deckId)
        if (index > 0) {
            val temp = currentOrder[index]
            currentOrder[index] = currentOrder[index - 1]
            currentOrder[index - 1] = temp
            setDeckOrderList(currentOrder)
        }
    }

    fun moveDeckDown(deckId: Long, allDeckIds: List<Long>) {
        val currentOrder = getDeckOrderList().toMutableList()
        allDeckIds.forEach { id ->
            if (!currentOrder.contains(id)) {
                currentOrder.add(id)
            }
        }
        val index = currentOrder.indexOf(deckId)
        if (index >= 0 && index < currentOrder.size - 1) {
            val temp = currentOrder[index]
            currentOrder[index] = currentOrder[index + 1]
            currentOrder[index + 1] = temp
            setDeckOrderList(currentOrder)
        }
    }
}

