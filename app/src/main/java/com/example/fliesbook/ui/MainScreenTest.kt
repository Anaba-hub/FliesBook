package com.example.fliesbook.ui

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.fliesbook.data.database.FlightDatabase
import com.example.fliesbook.data.preferences.PreferencesManager
import com.example.fliesbook.data.viewmodel.FlightSearchViewModel
import com.example.fliesbook.ui.MainScreen
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class MainScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var flightDatabase: FlightDatabase
    private lateinit var preferencesManager: PreferencesManager
    private lateinit var viewModel: FlightSearchViewModel

    @Before
    fun setUp() {
        val context = androidx.test.core.app.ApplicationProvider.getApplicationContext<android.content.Context>()
        flightDatabase = FlightDatabase.getDatabase(context)
        preferencesManager = PreferencesManager(context)
        viewModel = FlightSearchViewModel(flightDatabase.airportDao(), flightDatabase.favoriteDao(), preferencesManager)
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        flightDatabase.close()
    }

    @Test
    fun testSearchFieldUpdatesResults() = runBlocking {
        // Lancer l'écran principal avec le ViewModel
        composeTestRule.setContent {
            MainScreen(viewModel = viewModel)
        }

        // Tester si le champ de recherche met à jour les résultats
        val searchField = composeTestRule.onNodeWithText("Search by Airport Code...")
        searchField.performTextInput("CDG")

        // Vérifier si les résultats de recherche sont affichés
        composeTestRule.onNodeWithText("CDG - Charles de Gaulle")
            .assertIsDisplayed()
    }

    @Test
    fun testAddFavoriteButton() = runBlocking {
        // Lancer l'écran principal avec le ViewModel
        composeTestRule.setContent {
            MainScreen(viewModel = viewModel)
        }

        // Tester si le clic sur le bouton d'ajout aux favoris fonctionne
        val addButton = composeTestRule.onNodeWithText("Add to Favorites")
        addButton.performClick()

        // Vérifier si la section "Your Favorite Routes" est affichée
        composeTestRule.onNodeWithText("Your Favorite Routes")
            .assertIsDisplayed()
    }
}
