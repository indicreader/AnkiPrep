package com.example.flashcardapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "current_affairs_sources")
data class CurrentAffairsSourceEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val feedUrl: String,
    val isActive: Boolean = true,
    val addedTimestamp: Long = System.currentTimeMillis()
)
