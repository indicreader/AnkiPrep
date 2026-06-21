package com.example.flashcardapp.data.entities

import androidx.room.Entity

@Entity(tableName = "aliases", primaryKeys = ["name", "alias"])
data class AliasEntity(
    val name: String,   // lowercase normalized name
    val alias: String   // lowercase normalized alias
)
