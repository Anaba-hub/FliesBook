package com.example.fliesbook.data.preferences

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Extension pour créer une instance de DataStore associée au contexte
private val Context.dataStore by preferencesDataStore(name = "user_preferences")

class PreferencesManager(context: Context) {

    private val dataStore = context.dataStore

    companion object {
        // Clé utilisée pour sauvegarder la requête de recherche dans DataStore
        private val SEARCH_QUERY_KEY = stringPreferencesKey("search_query")
    }

    // Flow pour récupérer la requête de recherche actuelle à partir de DataStore
    val searchQuery: Flow<String?> = dataStore.data
        .map { preferences ->
            // Récupérer la requête de recherche sauvegardée ou retourner null si elle n'existe pas
            preferences[SEARCH_QUERY_KEY]
        }

    // Fonction pour sauvegarder la requête de recherche dans DataStore
    suspend fun saveSearchQuery(query: String) {
        dataStore.edit { preferences ->
            // Sauvegarder la requête de recherche dans les préférences avec la clé associée
            preferences[SEARCH_QUERY_KEY] = query
        }
    }
}
