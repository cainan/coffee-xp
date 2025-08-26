package com.cso.coffeexp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cso.coffeexp.data.database.dao.CoffeeDAO
import com.cso.coffeexp.data.model.local.CoffeeEntity

@Database(
    entities = [CoffeeEntity::class],
    version = 1,
    exportSchema = true,
    autoMigrations = []
)
@TypeConverters()
abstract class CoffeeXpDatabase : RoomDatabase() {
    abstract fun coffeeDao(): CoffeeDAO
}
