package com.cso.coffeexp.data.datasource.local

import com.cso.coffeexp.data.model.local.CoffeeEntity

interface CoffeeLocalDataSource {
    suspend fun insertCoffee(coffeeEntity: CoffeeEntity)
    suspend fun getAllCoffees(): List<CoffeeEntity>
    suspend fun getCoffeeById(id: Long): CoffeeEntity?

}