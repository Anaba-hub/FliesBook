package com.example.fliesbook

import android.app.Application
import com.example.fliesbook.data.database.FlightDatabase
import com.example.fliesbook.data.preferences.PreferencesManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class FlightApplication : Application() {

    // Scope de coroutine pour gérer les travaux en arrière-plan
    private val applicationScope = CoroutineScope(SupervisorJob())

    // Initialisation paresseuse de la base de données pour éviter de la créer avant qu'elle soit nécessaire
    val database by lazy { FlightDatabase.getDatabase(this) }

    // Initialisation paresseuse du gestionnaire des préférences
    val preferencesManager by lazy { PreferencesManager(this) }
}
