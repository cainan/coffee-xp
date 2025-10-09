package com.cso.coffeexp.data.repository

import android.util.Log
import com.cso.coffeexp.data.datasource.local.CoffeeLocalDataSource
import com.cso.coffeexp.data.mapper.toCoffee
import com.cso.coffeexp.data.mapper.toCoffeeEntity
import com.cso.coffeexp.domain.model.Coffee
import com.cso.coffeexp.domain.repository.CoffeeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private const val TAG = "CoffeeRepositoryImpl"

class CoffeeRepositoryImpl(
    val localDataSource: CoffeeLocalDataSource,
) : CoffeeRepository {

    override suspend fun getAllCoffees(): List<Coffee> = withContext(Dispatchers.IO) {
        Log.d(TAG, "Getting all coffees")
        return@withContext localDataSource.getAllCoffees().map { it.toCoffee() }
    }

    override suspend fun getCoffeeById(id: Long): Coffee? = withContext(Dispatchers.IO) {
        Log.d(TAG, "Getting coffee with id $id")
        localDataSource.getCoffeeById(id)?.toCoffee()
    }

    override suspend fun insertCoffee(coffee: Coffee): Boolean {
        Log.d(TAG, "Inserting coffee: $coffee")
        localDataSource.insertCoffee(coffee.toCoffeeEntity())
        return false
    }

    override suspend fun updateCoffee(coffee: Coffee): Boolean = withContext(Dispatchers.IO) {
        Log.d(TAG, "Updating coffee: $coffee")
        localDataSource.updateCoffee(coffee.toCoffeeEntity())
    }

    override suspend fun removeCoffee(id: Long): Boolean = withContext(Dispatchers.IO) {
        Log.d(TAG, "Removing coffee: $id")
        localDataSource.removeCoffee(id)
    }

}