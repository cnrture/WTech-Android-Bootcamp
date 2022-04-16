package com.canerture.wtechrecyclerview

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Kitap::class], version = 1)
abstract class KitaplarDatabase: RoomDatabase() {

    abstract fun kitaplarDAO(): KitaplarDAO

    companion object {

        private var instance: KitaplarDatabase? = null

        fun getirKitaplarDatabase(context: Context): KitaplarDatabase? {

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    KitaplarDatabase::class.java,
                    "kitaplar.db")
                    .allowMainThreadQueries()
                    .build()
            }

            return instance
        }
    }
}