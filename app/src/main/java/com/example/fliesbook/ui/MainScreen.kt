package com.example.fliesbook.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fliesbook.FlightApplication
import com.example.fliesbook.data.model.Airport
import com.example.fliesbook.data.model.Favorite
import com.example.fliesbook.data.viewmodel.FlightSearchViewModel
import com.example.fliesbook.data.viewmodel.FlightSearchViewModelFactory

@Composable
fun MainScreen(viewModel: FlightSearchViewModel = viewModel()) {
    val application = LocalContext.current.applicationContext as FlightApplication
    val viewModel: FlightSearchViewModel = viewModel(
        factory = FlightSearchViewModelFactory(
            airportDao = application.database.airportDao(),
            favoriteDao = application.database.favoriteDao(),
            preferencesManager = application.preferencesManager
        )
    )
    var query by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Search Field
        BasicTextField(
            value = query,
            onValueChange = {
                query = it
                viewModel.searchAirports(query.text)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(horizontal = 8.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (query.text.isEmpty()) {
                        Text(
                            text = "Search by Airport Code...",
                            style = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f))
                        )
                    }
                    innerTextField()
                }
            }
        )

        // Search Results
        val searchResults by viewModel.searchResults.collectAsState()
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(searchResults) { airport ->
                AirportItem(airport = airport, onAddFavorite = { viewModel.addFavorite(airport.iataCode, "DestinationCode") })
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Favorites Section
        val favorites by viewModel.favorites.collectAsState()
        Text(
            text = "Your Favorite Routes",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(favorites) { favorite ->
                FavoriteItem(favorite = favorite, onDeleteFavorite = { viewModel.deleteFavorite(favorite.id) })
            }
        }
    }
}

@Composable
fun AirportItem(airport: Airport, onAddFavorite: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${airport.iataCode} - ${airport.name}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f)
            )
            TextButton(onClick = onAddFavorite) {
                Text(text = "Add to Favorites")
            }
        }
    }
}

@Composable
fun FavoriteItem(favorite: Favorite, onDeleteFavorite: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${favorite.departureCode} -> ${favorite.destinationCode}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f)
            )
            TextButton(onClick = onDeleteFavorite) {
                Text(text = "Delete")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}
