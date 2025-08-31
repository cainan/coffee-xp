package com.cso.coffeexp.data.datasource.local.impl

import android.util.Log
import com.cso.coffeexp.data.database.dao.CoffeeDAO
import com.cso.coffeexp.data.datasource.local.CoffeeLocalDataSource
import com.cso.coffeexp.data.model.local.CoffeeEntity

private const val TAG = "CoffeeLocalDataSourceImpl"

class CoffeeLocalDataSourceImpl(
    val coffeeDao: CoffeeDAO,
) : CoffeeLocalDataSource {

    override suspend fun insertCoffee(coffeeEntity: CoffeeEntity) {
        coffeeDao.insert(coffeeEntity)
        Log.d(TAG, "Coffee inserted!!")
    }
}