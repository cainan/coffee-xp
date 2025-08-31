package com.cso.coffeexp.data.repository

import android.util.Log
import com.cso.coffeexp.data.datasource.local.CoffeeLocalDataSource
import com.cso.coffeexp.data.mapper.toCoffeeEntity
import com.cso.coffeexp.domain.model.Coffee
import com.cso.coffeexp.domain.repository.CoffeeRepository

private const val TAG = "CoffeeRepositoryImpl"

class CoffeeRepositoryImpl(
    val localDataSource: CoffeeLocalDataSource,
) : CoffeeRepository {

    override suspend fun getAllCoffees(): List<Coffee> {
        TODO("Not yet implemented")
    }

    override suspend fun getCoffeeById(id: String): Coffee {
        TODO("Not yet implemented")
    }

    override suspend fun insertCoffee(coffee: Coffee): Boolean {
        Log.d(TAG, "Inserting coffee: $coffee")
        localDataSource.insertCoffee(coffee.toCoffeeEntity())
        return false
    }
}