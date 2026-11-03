package com.example.flashcardapp.ui.theme

import android.content.Context
import androidx.compose.runtime.*
import com.example.flashcardapp.data.SettingsRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Key-driven Exam Simulation Theme Manager.
 * Provides authentic official exam presets (TCS iON, NTA, Tactical Dark)
 * and allows saving & previewing custom themes created in Theme Studio.
 */
object ExamThemeManager {
    // ── Official & Standard Presets ──────────────────────────────────────────────

    val PRESET_TCS_ION = ExamThemeTokens(
        key = "TCS_ION",
        displayName = "TCS iON (SSC / Banking / RRB)",
        isCustom = false,
        isDark = false,
        windowBackground = 0xFFF5F7FA.toInt(),
        surfaceColor = 0xFFFFFFFF.toInt(),
        borderColor = 0xFFD1D5DB.toInt(),
        primaryText = 0xFF1F2937.toInt(),
        secondaryText = 0xFF4B5563.toInt(),
        colorAnswered = 0xFF2E7D32.toInt(),          // Official TCS Vibrant Green
        colorNotAnswered = 0xFFE65100.toInt(),       // Official TCS Dark Orange / Red
        colorMarkedForReview = 0xFF6A1B9A.toInt(),   // Official TCS Purple / Violet
        colorAnsweredAndReview = 0xFF4527A0.toInt(), // Official TCS Deep Violet with badge
        colorNotVisited = 0xFFE0E0E0.toInt(),        // Inactive Grey
        buttonCornerRadiusDp = 4,
        buttonElevationDp = 1
    )

    val PRESET_NTA_CONSOLE = ExamThemeTokens(
        key = "NTA_CONSOLE",
        displayName = "NTA Console (NEET / JEE / CUET)",
        isCustom = false,
        isDark = false,
        windowBackground = 0xFFF0F4F8.toInt(),
        surfaceColor = 0xFFFFFFFF.toInt(),
        borderColor = 0xFFCBD5E1.toInt(),
        primaryText = 0xFF0F172A.toInt(),
        secondaryText = 0xFF334155.toInt(),
        colorAnswered = 0xFF16A34A.toInt(),
        colorNotAnswered = 0xFFDC2626.toInt(),
        colorMarkedForReview = 0xFF9333EA.toInt(),
        colorAnsweredAndReview = 0xFF7E22CE.toInt(),
        colorNotVisited = 0xFFE2E8F0.toInt(),
        buttonCornerRadiusDp = 6,
        buttonElevationDp = 2
    )

    val PRESET_TACTICAL_DARK = ExamThemeTokens(
        key = "TACTICAL_DARK",
        displayName = "Tactical Dark / OLED",
        isCustom = false,
        isDark = true,
        windowBackground = 0xFF0D1117.toInt(),
        surfaceColor = 0xFF161B22.toInt(),
        borderColor = 0xFF30363D.toInt(),
        primaryText = 0xFFF0F6FC.toInt(),
        secondaryText = 0xFF8B949E.toInt(),
        colorAnswered = 0xFF238636.toInt(),
        colorNotAnswered = 0xFFDA3633.toInt(),
        colorMarkedForReview = 0xFF8957E5.toInt(),
        colorAnsweredAndReview = 0xFFA371F7.toInt(),
        colorNotVisited = 0xFF21262D.toInt(),
        buttonCornerRadiusDp = 8,
        buttonElevationDp = 2
    )

    val PRESET_CYBER_MINT = ExamThemeTokens(
        key = "CYBER_MINT",
        displayName = "Cyber Mint Dark",
        isCustom = false,
        isDark = true,
        windowBackground = 0xFF0A0F1D.toInt(),
        surfaceColor = 0xFF131C31.toInt(),
        borderColor = 0xFF00E5FF.toInt(),
        primaryText = 0xFFE2E8F0.toInt(),
        secondaryText = 0xFF94A3B8.toInt(),
        colorAnswered = 0xFF00E676.toInt(),
        colorNotAnswered = 0xFFFF5252.toInt(),
        colorMarkedForReview = 0xFF7C4DFF.toInt(),
        colorAnsweredAndReview = 0xFF651FFF.toInt(),
        colorNotVisited = 0xFF1E293B.toInt(),
        buttonCornerRadiusDp = 10,
        buttonElevationDp = 3
    )

    val ALL_PRESETS = listOf(
        PRESET_TCS_ION,
        PRESET_NTA_CONSOLE,
        PRESET_TACTICAL_DARK,
        PRESET_CYBER_MINT
    )

    // ── Active Theme State ───────────────────────────────────────────────────────
    var currentTokens by mutableStateOf(PRESET_TACTICAL_DARK)
        private set

    private const val PREF_ACTIVE_THEME_KEY = "exam_theme_active_key"
    private const val PREF_CUSTOM_THEMES_JSON = "exam_theme_custom_list_json"
    private val gson = Gson()

    /**
     * Initializes the theme engine from persistent settings.
     */
    fun init(context: Context) {
        val prefs = context.getSharedPreferences("ankiprep_settings", Context.MODE_PRIVATE)
        val activeKey = prefs.getString(PREF_ACTIVE_THEME_KEY, PRESET_TACTICAL_DARK.key) ?: PRESET_TACTICAL_DARK.key
        val customList = getCustomThemes(context)

        val found = (ALL_PRESETS + customList).firstOrNull { it.key == activeKey }
            ?: PRESET_TACTICAL_DARK
        currentTokens = found
    }

    /**
     * Sets the active theme by key and persists the choice.
     */
    fun selectTheme(context: Context, key: String) {
        val allAvailable = ALL_PRESETS + getCustomThemes(context)
        val target = allAvailable.firstOrNull { it.key == key } ?: return
        currentTokens = target

        val prefs = context.getSharedPreferences("ankiprep_settings", Context.MODE_PRIVATE)
        prefs.edit().putString(PREF_ACTIVE_THEME_KEY, key).apply()
    }

    /**
     * Returns all saved custom themes created in Theme Studio.
     */
    fun getCustomThemes(context: Context): List<ExamThemeTokens> {
        val prefs = context.getSharedPreferences("ankiprep_settings", Context.MODE_PRIVATE)
        val json = prefs.getString(PREF_CUSTOM_THEMES_JSON, null) ?: return emptyList()
        return try {
            val type = object : TypeToken<List<ExamThemeTokens>>() {}.type
            gson.fromJson<List<ExamThemeTokens>>(json, type) ?: emptyList()
        } catch (_: Exception) {
            emptyList()
        }
    }

    /**
     * Saves or updates a custom theme in persistent storage.
     */
    fun saveCustomTheme(context: Context, tokens: ExamThemeTokens) {
        val existing = getCustomThemes(context).toMutableList()
        existing.removeAll { it.key == tokens.key }
        existing.add(tokens.copy(isCustom = true))

        val prefs = context.getSharedPreferences("ankiprep_settings", Context.MODE_PRIVATE)
        prefs.edit().putString(PREF_CUSTOM_THEMES_JSON, gson.toJson(existing)).apply()

        // If the saved theme is currently active, update in-memory state
        if (currentTokens.key == tokens.key) {
            currentTokens = tokens
        }
    }

    /**
     * Deletes a custom theme from persistent storage.
     */
    fun deleteCustomTheme(context: Context, key: String) {
        val existing = getCustomThemes(context).toMutableList()
        existing.removeAll { it.key == key }

        val prefs = context.getSharedPreferences("ankiprep_settings", Context.MODE_PRIVATE)
        prefs.edit().putString(PREF_CUSTOM_THEMES_JSON, gson.toJson(existing)).apply()

        if (currentTokens.key == key) {
            selectTheme(context, PRESET_TACTICAL_DARK.key)
        }
    }
}

/**
 * CompositionLocal providing access to current ExamThemeTokens throughout the Compose hierarchy.
 */
val LocalExamThemeTokens = compositionLocalOf { ExamThemeManager.PRESET_TACTICAL_DARK }

