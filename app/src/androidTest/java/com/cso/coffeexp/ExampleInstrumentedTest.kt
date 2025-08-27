package com.cso.coffeexp

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.cso.coffeexp.data.database.CoffeeXpDatabase
import com.cso.coffeexp.data.model.local.CoffeeEntity
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.cso.coffeexp", appContext.packageName)
    }

    @Test
    fun testCoffeeLocalDatabase() = runTest {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext

        val db = Room.databaseBuilder(
            appContext,
            CoffeeXpDatabase::class.java, "coffee-db-test"
        ).build()

        val coffeeDao = db.coffeeDao()
        coffeeDao.insert(CoffeeEntity(name = "Espresso"))

        val all = coffeeDao.getAll()
        println("---- ${all.size}")
        println(all)
        println("---- ${all[0].name}")
    }
}