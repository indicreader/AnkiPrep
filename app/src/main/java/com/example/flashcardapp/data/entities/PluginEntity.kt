package com.example.flashcardapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plugins")
data class PluginEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val version: String = "1.0.0",
    val author: String = "Community",
    val inputType: String = "TEXT_PDF", // TEXT_PDF, RSS_ATOM, HTML_SCRAPE
    val description: String = "",
    val scriptContent: String,
    val isEnabled: Boolean = true,
    val installedAt: Long = System.currentTimeMillis()
)
