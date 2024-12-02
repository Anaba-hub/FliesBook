package com.example.fliesbook.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.fliesbook.data.model.Airport

@Dao
interface AirportDao {

    @Insert
    suspend fun insertAirport(airport: Airport)

    @Query("SELECT * FROM airport WHERE iataCode LIKE :iataCode LIMIT 10")
    suspend fun searchAirportsByCode(iataCode: String): List<Airport>

    @Query("SELECT * FROM airport WHERE id = :id")
    suspend fun getAirportById(id: Int): Airport
}
