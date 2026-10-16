package com.example.flashcardapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.flashcardapp.data.entities.PluginEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PluginDao {
    @Query("SELECT * FROM plugins ORDER BY installedAt DESC")
    fun observeAllPlugins(): Flow<List<PluginEntity>>

    @Query("SELECT * FROM plugins ORDER BY installedAt DESC")
    suspend fun getAllPluginsSync(): List<PluginEntity>

    @Query("SELECT * FROM plugins WHERE id = :id LIMIT 1")
    suspend fun getPluginById(id: String): PluginEntity?

    @Query("SELECT * FROM plugins WHERE inputType = :inputType AND isEnabled = 1 ORDER BY name ASC")
    suspend fun getEnabledPluginsForType(inputType: String): List<PluginEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertPlugin(plugin: PluginEntity)

    @Update
    suspend fun updatePlugin(plugin: PluginEntity)

    @Delete
    suspend fun deletePlugin(plugin: PluginEntity)

    @Query("DELETE FROM plugins WHERE id = :id")
    suspend fun deletePluginById(id: String)

    @Query("UPDATE plugins SET isEnabled = :isEnabled WHERE id = :id")
    suspend fun updateEnabledStatus(id: String, isEnabled: Boolean)
}
