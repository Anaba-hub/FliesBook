package com.example.fliesbook.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.fliesbook.data.viewmodel.FlightSearchViewModel
import com.example.fliesbook.ui.theme.FliesBookTheme
import com.example.fliesbook.FlightApplication
import com.example.fliesbook.data.viewmodel.FlightSearchViewModelFactory

class MainActivity : ComponentActivity() {

    // Initialisation du ViewModel avec le FlightApplication
    private val flightSearchViewModel: FlightSearchViewModel by viewModels {
        FlightSearchViewModelFactory((application as FlightApplication).database.airportDao(),
            (application as FlightApplication).database.favoriteDao(),
            (application as FlightApplication).preferencesManager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FliesBookTheme {
                // Lancer l'écran principal
                MainScreen(viewModel = flightSearchViewModel)
            }
        }
    }
}
