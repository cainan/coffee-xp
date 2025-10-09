package com.cso.coffeexp.domain.repository

import com.cso.coffeexp.domain.model.Coffee

interface CoffeeRepository {
    suspend fun getAllCoffees(): List<Coffee>
    suspend fun getCoffeeById(id: Long): Coffee?
    suspend fun insertCoffee(coffee: Coffee): Boolean
    suspend fun updateCoffee(coffee: Coffee): Boolean
    suspend fun removeCoffee(id: Long): Boolean
}