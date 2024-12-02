package com.example.fliesbook.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fliesbook.data.dao.AirportDao
import com.example.fliesbook.data.dao.FavoriteDao
import com.example.fliesbook.data.preferences.PreferencesManager

class FlightSearchViewModelFactory(
    private val airportDao: AirportDao,
    private val favoriteDao: FavoriteDao,
    private val preferencesManager: PreferencesManager
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FlightSearchViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FlightSearchViewModel(airportDao, favoriteDao, preferencesManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
