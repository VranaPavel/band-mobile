package com.crowthedev.band.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NameDao {

    @Upsert
    suspend fun addName(name: Name)

    @Query("SELECT * FROM name_table ORDER BY id ASC")
    fun readAllData(): Flow<List<Name>>

    @Delete
    fun deleteName(name: Name)
}