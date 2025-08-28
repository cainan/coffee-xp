package com.cso.coffeexp.data.repository

import android.util.Log
import com.cso.coffeexp.domain.model.Coffee
import com.cso.coffeexp.domain.repository.CoffeeRepository

private const val TAG = "CoffeeRepositoryImpl"

class CoffeeRepositoryImpl : CoffeeRepository {

    override suspend fun getAllCoffees(): List<Coffee> {
        TODO("Not yet implemented")
    }

    override suspend fun getCoffeeById(id: String): Coffee {
        TODO("Not yet implemented")
    }

    override suspend fun insertCoffee(coffee: Coffee): Boolean {
        Log.d(TAG, "Inserting coffee: $coffee")
        return false
    }
}