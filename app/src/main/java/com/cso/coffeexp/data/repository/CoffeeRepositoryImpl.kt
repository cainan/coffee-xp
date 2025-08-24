package com.cso.coffeexp.data.repository

import com.cso.coffeexp.domain.model.Coffee
import com.cso.coffeexp.domain.repository.CoffeeRepository

class CoffeeRepositoryImpl : CoffeeRepository {
    override suspend fun getAllCoffees(): List<Coffee> {
        TODO("Not yet implemented")
    }

    override suspend fun getCoffeeById(id: String): Coffee {
        TODO("Not yet implemented")
    }
}