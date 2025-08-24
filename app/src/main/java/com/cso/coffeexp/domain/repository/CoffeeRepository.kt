package com.cso.coffeexp.domain.repository

import com.cso.coffeexp.domain.model.Coffee

interface CoffeeRepository {
    suspend fun getAllCoffees(): List<Coffee>
    suspend fun getCoffeeById(id : String) : Coffee
}