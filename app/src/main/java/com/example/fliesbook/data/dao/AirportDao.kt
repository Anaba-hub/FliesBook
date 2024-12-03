package com.example.fliesbook.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.fliesbook.data.model.Airport

@Dao
interface AirportDao {

    // Insérer un nouvel aéroport dans la base de données
    @Insert
    fun insertAirport(airport: Airport)

    // Rechercher des aéroports dont le code IATA correspond à la requête fournie
    @Query("SELECT * FROM airport WHERE iata_code LIKE :iataCode LIMIT 10")
    fun searchAirportsByCode(iataCode: String): List<Airport>

    // Récupérer un aéroport spécifique par son ID
    @Query("SELECT * FROM airport WHERE id = :id")
    fun getAirportById(id: Int): Airport
}
