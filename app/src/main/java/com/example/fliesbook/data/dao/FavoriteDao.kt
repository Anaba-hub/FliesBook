package com.example.fliesbook.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.fliesbook.data.model.Favorite

@Dao
interface FavoriteDao {

    @Insert
    suspend fun insertFavorite(favorite: Favorite)

    @Query("SELECT * FROM favorite")
    suspend fun getAllFavorites(): List<Favorite>

    @Query("DELETE FROM favorite WHERE id = :id")
    suspend fun deleteFavoriteById(id: Int)
}
