package com.cso.coffeexp.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cso.coffeexp.domain.model.Coffee
import com.cso.coffeexp.domain.repository.CoffeeRepository
import com.cso.coffeexp.domain.usecase.GetAllCoffeesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    val getAllCoffeesUseCase: GetAllCoffeesUseCase,
    private val repository: CoffeeRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUIState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.OnInit -> getHomeContent()
            is HomeEvent.OnRemoveCoffee -> onRemoveCoffee(event.coffee)
            is HomeEvent.OnSearch -> onSearchCoffee(event.query)
        }
    }

    private fun onSearchCoffee(query: String) {
        viewModelScope.launch {

            _uiState.update {
                it.copy(isLoading = true)
            }

            getAllCoffeesUseCase().collect { it ->
                val coffeeList = it.filter {
                    it.name.contains(query, ignoreCase = true)
                }
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        coffeeList = coffeeList
                    )
                }
            }
        }
    }

    private fun onRemoveCoffee(coffee: Coffee) {
        viewModelScope.launch {

            _uiState.update {
                it.copy(isLoading = true)
            }

            coffee.id?.let {
                val removeCoffee = repository.removeCoffee(it)
                if (removeCoffee) {
                    getAllCoffees()
                }
            }
        }
    }

    private fun getHomeContent() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true)
            }

            getAllCoffees()
        }
    }

    private suspend fun getAllCoffees() {
        getAllCoffeesUseCase().collect { coffeeList ->
            _uiState.update {
                it.copy(
                    isLoading = false,
                    coffeeList = coffeeList
                )
            }
        }
    }
}