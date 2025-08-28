package com.cso.coffeexp.domain.usecase

import com.cso.coffeexp.domain.model.Coffee
import com.cso.coffeexp.domain.repository.CoffeeRepository

class InsertCoffeeUseCase (
    private val repository: CoffeeRepository
) {
    suspend operator fun invoke(coffee: Coffee): Boolean = repository.insertCoffee(coffee)
}