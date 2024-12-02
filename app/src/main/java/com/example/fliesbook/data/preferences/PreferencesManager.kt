package com.example.fliesbook.data.preferences

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Extension property to create a DataStore instance associated with the context
private val Context.dataStore by preferencesDataStore(name = "user_preferences")

class PreferencesManager(context: Context) {

    private val dataStore = context.dataStore

    companion object {
        // Key used to store the search query in DataStore
        private val SEARCH_QUERY_KEY = stringPreferencesKey("search_query")
    }

    // Flow to retrieve the current search query from DataStore
    val searchQuery: Flow<String?> = dataStore.data
        .map { preferences ->
            // Retrieve the saved search query or return null if it doesn't exist
            preferences[SEARCH_QUERY_KEY]
        }

    // Function to save the search query into DataStore
    suspend fun saveSearchQuery(query: String) {
        dataStore.edit { preferences ->
            // Save the search query in the preferences with the associated key
            preferences[SEARCH_QUERY_KEY] = query
        }
    }
}
