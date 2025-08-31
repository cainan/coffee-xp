package com.cso.coffeexp.domain.usecase

import com.cso.coffeexp.domain.model.Coffee
import com.cso.coffeexp.domain.repository.CoffeeRepository
import kotlinx.coroutines.flow.flow

class GetAllCoffeesUserCase(
    private val repository: CoffeeRepository,
) {
    operator fun invoke(coffee: Coffee) = flow {
        emit(repository.getAllCoffees())
    }
}