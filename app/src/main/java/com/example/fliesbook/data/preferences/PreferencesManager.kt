package com.example.fliesbook.data.preferences

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "user_preferences")

class PreferencesManager(context: Context) {

    private val dataStore = context.dataStore

    companion object {
        private val SEARCH_QUERY_KEY = stringPreferencesKey("search_query")
    }

    val searchQuery: Flow<String?> = dataStore.data
        .map { preferences ->
            preferences[SEARCH_QUERY_KEY]
        }

    suspend fun saveSearchQuery(query: String) {
        dataStore.edit { preferences ->
            preferences[SEARCH_QUERY_KEY] = query
        }
    }
}
