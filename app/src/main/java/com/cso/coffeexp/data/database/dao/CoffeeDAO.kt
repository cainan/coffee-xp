package com.cso.coffeexp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.cso.coffeexp.data.model.local.CoffeeEntity

@Dao
interface CoffeeDAO {

    @Insert(onConflict = REPLACE)
    suspend fun insert(coffee: CoffeeEntity)

    @Query("SELECT * FROM coffee")
    fun getAll(): List<CoffeeEntity>

    @Query("SELECT * FROM coffee WHERE id = :id")
    fun getCoffeeById(id: Long): CoffeeEntity?
}