package com.canerture.wtechroomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [GelirGiderModel::class], version = 1)
abstract class GelirGiderDatabase: RoomDatabase() {

    abstract fun gelirGiderDAO(): GelirGiderDAO

    companion object {

        private var instance: GelirGiderDatabase? = null

        fun getirGelirGiderDatabase(context: Context): GelirGiderDatabase? {

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    GelirGiderDatabase::class.java,
                    "gelirgider.db")
                    .allowMainThreadQueries()
                    .build()
            }

            return instance
        }

    }

}