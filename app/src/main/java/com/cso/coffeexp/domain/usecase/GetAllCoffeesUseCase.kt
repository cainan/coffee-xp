package com.cso.coffeexp.domain.usecase

import com.cso.coffeexp.domain.model.Coffee
import com.cso.coffeexp.domain.repository.CoffeeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetAllCoffeesUseCase(
    private val repository: CoffeeRepository,
) {
    operator fun invoke(): Flow<List<Coffee>> = flow {
        emit(repository.getAllCoffees())
    }
}