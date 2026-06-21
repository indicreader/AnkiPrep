package com.example.flashcardapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.flashcardapp.data.entities.AliasEntity

import kotlinx.coroutines.flow.Flow

@Dao
interface AliasDao {
    @Query("SELECT * FROM aliases")
    fun getAllAliasesFlow(): Flow<List<AliasEntity>>

    @Query("SELECT * FROM aliases")
    suspend fun getAllAliases(): List<AliasEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAlias(alias: AliasEntity): Long

    @androidx.room.Delete
    suspend fun deleteAlias(alias: AliasEntity)

    @Query("SELECT COUNT(*) FROM aliases WHERE (name = :name AND alias = :alias) OR (name = :alias AND alias = :name)")
    suspend fun exists(name: String, alias: String): Int
}
