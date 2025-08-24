package com.cso.coffeexp.ui.screen.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cso.coffeexp.domain.model.Coffee
import com.cso.coffeexp.ui.mock.mockCoffeeData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailsViewModel(
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailsUIState(isLoading = false, coffee = Coffee()))
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: DetailsEvent) {
        when (event) {
            is DetailsEvent.FindCoffeeById -> findCoffeeById(event.coffeeId)
        }
    }

    private fun findCoffeeById(id: String) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true)
            }

            _uiState.update {
                it.copy(
                    isLoading = false,
                    coffee = mockCoffeeData.firstOrNull { coffee -> coffee.id == id } ?: Coffee())
            }
        }
    }


}