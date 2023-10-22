package com.crowthedev.band.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "name_table")
data class Name(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val nameInserted: String
)