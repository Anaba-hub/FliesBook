package com.example.fliesbook.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fliesbook.data.dao.AirportDao
import com.example.fliesbook.data.dao.FavoriteDao
import com.example.fliesbook.data.model.Airport
import com.example.fliesbook.data.model.Favorite

@Database(entities = [Airport::class, Favorite::class], version = 1, exportSchema = false)
abstract class FlightDatabase: RoomDatabase() {

    abstract fun airportDao(): AirportDao
    abstract fun favoriteDao(): FavoriteDao

    companion object {
        @Volatile
        private var INSTANCE: FlightDatabase? = null

        fun getDatabase(context: Context): FlightDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FlightDatabase::class.java,
                    "flight_search_database"
                ).createFromAsset("database/flight_search.db")
                    .fallbackToDestructiveMigrationFrom()
                    .build()
                instance.also { INSTANCE = it }
                instance
            }
        }
    }
}