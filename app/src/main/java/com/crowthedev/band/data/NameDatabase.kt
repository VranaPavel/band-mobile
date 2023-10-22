package com.crowthedev.band.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Name::class], version = 1, exportSchema = false)
abstract class NameDatabase : RoomDatabase() {

    abstract fun nameDao(): NameDao

    companion object {
        @Volatile
        private var INSTANCE: NameDatabase? = null

        fun getDatabase(context: Context): NameDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NameDatabase::class.java,
                    "name_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}



/*
abstract class NameDatabase: RoomDatabase() {

    abstract fun nameDao(): NameDao

    companion object {
        @Volatile
        private var INSTANCE: NameDatabase? = null

        fun getDatabase(context: Context): NameDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NameDatabase::class.java,
                    "name_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
*/