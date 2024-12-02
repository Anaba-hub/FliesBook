package com.example.fliesbook.ui

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.fliesbook.data.viewmodel.FlightSearchViewModel
import org.junit.Rule
import org.junit.Test

class MainScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testSearchFieldUpdatesResults() {
        val viewModel = FlightSearchViewModel(/* Pass necessary dependencies here */)

        composeTestRule.setContent {
            MainScreen(viewModel = viewModel)
        }

        val searchField = composeTestRule.onNodeWithText("Search by Airport Code...")
        searchField.performTextInput("CDG")

        composeTestRule.onNodeWithText("CDG - Charles de Gaulle")
            .assertIsDisplayed()
    }

    @Test
    fun testAddFavoriteButton() {
        val viewModel = FlightSearchViewModel(/* Pass necessary dependencies here */)

        composeTestRule.setContent {
            MainScreen(viewModel = viewModel)
        }

        val addButton = composeTestRule.onNodeWithText("Add to Favorites")
        addButton.performClick()

        composeTestRule.onNodeWithText("Your Favorite Routes")
            .assertIsDisplayed()
    }
}
