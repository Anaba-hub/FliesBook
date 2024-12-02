package com.example.fliesbook.data.dao

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.room.Room
import androidx.test.filters.SmallTest
import com.example.fliesbook.data.database.FlightDatabase
import com.example.fliesbook.data.model.Airport
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class AirportDaoTest {

    private lateinit var database: FlightDatabase
    private lateinit var airportDao: AirportDao

    @Before
    fun setup() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, FlightDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        airportDao = database.airportDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertAndSearchAirport() = runBlocking {
        val airport = Airport(1, "CDG", "Charles de Gaulle", 100000)
        airportDao.insertAirport(airport)

        val result = airportDao.searchAirportsByCode("CDG")
        assertEquals(1, result.size)
        assertEquals(airport, result[0])
    }
}
