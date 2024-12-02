package com.example.fliesbook

import android.app.Application
import com.example.fliesbook.data.database.FlightDatabase
import com.example.fliesbook.data.preferences.PreferencesManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class FlightApplication: Application() {

    private val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { FlightDatabase.getDatabase(this) }
    val preferencesManager by lazy { PreferencesManager(this) }
}