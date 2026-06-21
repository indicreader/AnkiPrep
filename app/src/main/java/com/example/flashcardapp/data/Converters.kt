package com.example.flashcardapp.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Room TypeConverters for serializing complex types to/from SQLite-compatible formats.
 *
 * Tags are stored as JSON arrays in the database and deserialized to List<String> at runtime.
 */
class Converters {

    private val gson = Gson()

    @TypeConverter
    fun fromTagsList(tags: List<String>): String {
        return gson.toJson(tags)
    }

    @TypeConverter
    fun toTagsList(tagsJson: String): List<String> {
        if (tagsJson.isBlank()) return emptyList()
        val type = object : TypeToken<List<String>>() {}.type
        return try {
            gson.fromJson(tagsJson, type) ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }
}
