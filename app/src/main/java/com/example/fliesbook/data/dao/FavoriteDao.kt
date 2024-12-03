package com.example.fliesbook.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.fliesbook.data.model.Favorite

@Dao
interface FavoriteDao {

    // Insérer un nouvel itinéraire favori dans la base de données
    @Insert
    fun insertFavorite(favorite: Favorite)

    // Récupérer tous les itinéraires favoris depuis la base de données
    @Query("SELECT * FROM favorite")
    fun getAllFavorites(): List<Favorite>

    // Supprimer un itinéraire favori par son ID
    @Query("DELETE FROM favorite WHERE id = :id")
    fun deleteFavoriteById(id: Int)
}
