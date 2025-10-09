package com.cso.coffeexp.data.datasource.local.impl

import android.util.Log
import com.cso.coffeexp.data.database.dao.CoffeeDAO
import com.cso.coffeexp.data.datasource.local.CoffeeLocalDataSource
import com.cso.coffeexp.data.model.local.CoffeeEntity


class CoffeeLocalDataSourceImpl(
    val coffeeDao: CoffeeDAO,
) : CoffeeLocalDataSource {

    override suspend fun insertCoffee(coffeeEntity: CoffeeEntity) =
        coffeeDao.insert(coffeeEntity)

    override suspend fun getAllCoffees(): List<CoffeeEntity> =
        coffeeDao.getAll()

    override suspend fun getCoffeeById(id: Long): CoffeeEntity? =
        coffeeDao.getCoffeeById(id)

    override suspend fun updateCoffee(coffeeEntity: CoffeeEntity): Boolean {
        val success = coffeeDao.updateCoffee(coffeeEntity)
        Log.d("CoffeeLocalDataSource", "Updated coffee: $success")
        return success > 0
    }

    override suspend fun removeCoffee(id: Long): Boolean {
        val success = coffeeDao.removeCoffee(id)
        Log.d("CoffeeLocalDataSource", "Removed coffee: $success")
        return success > 0
    }

}