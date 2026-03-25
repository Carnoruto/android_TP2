package com.tonpackage.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [NinjaEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun ninjaDao(): NinjaDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "ninja_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}