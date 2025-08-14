package com.cso.coffeexp.ui.screen.coffee

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CoffeeViewModel(
) : ViewModel() {

    private val _uiState = MutableStateFlow(CoffeeUIState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: CoffeeEvent) {
        when (event) {
            CoffeeEvent.OnInit -> getHomeContent()
        }
    }

    private fun getHomeContent() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true)
            }

        }
    }
}