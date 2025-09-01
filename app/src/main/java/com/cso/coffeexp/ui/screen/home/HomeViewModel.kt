package com.cso.coffeexp.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cso.coffeexp.domain.usecase.GetAllCoffeesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    val getAllCoffeesUseCase: GetAllCoffeesUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUIState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.OnInit -> getHomeContent()
        }
    }

    private fun getHomeContent() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true)
            }

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
}