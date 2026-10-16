package com.example.flashcardapp.data.scraper

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * User-defined custom website scraper configuration rule.
 */
data class CustomScraperRule(
    val id: String = java.util.UUID.randomUUID().toString(),
    val name: String,
    val domain: String,
    val questionSelector: String = ".question, h3, h4",
    val optionSelector: String = ".option, li",
    val answerSelector: String = ".answer, .correct",
    val explanationSelector: String = ".explanation, .solution",
    val nextSelector: String = "a[rel=next], a:contains(Next)"
)

object CustomScraperManager {
    private const val PREFS_NAME = "custom_scrapers_prefs"
    private const val KEY_RULES = "saved_custom_scraper_rules"

    fun getRules(context: Context): List<CustomScraperRule> {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val json = prefs.getString(KEY_RULES, null) ?: return emptyList()
        return try {
            val type = object : TypeToken<List<CustomScraperRule>>() {}.type
            Gson().fromJson(json, type) ?: emptyList()
        } catch (_: Exception) {
            emptyList()
        }
    }

    fun saveRule(context: Context, rule: CustomScraperRule) {
        val current = getRules(context).toMutableList()
        current.removeAll { it.id == rule.id || it.domain.equals(rule.domain, ignoreCase = true) }
        current.add(rule)
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putString(KEY_RULES, Gson().toJson(current)).apply()
    }

    fun deleteRule(context: Context, ruleId: String) {
        val current = getRules(context).toMutableList()
        current.removeAll { it.id == ruleId }
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putString(KEY_RULES, Gson().toJson(current)).apply()
    }
}
