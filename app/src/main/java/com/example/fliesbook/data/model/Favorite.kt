package com.example.fliesbook.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite")
data class Favorite(
    @PrimaryKey val id: Int,
    val departureCode: String,
    val destinationCode: String
)
