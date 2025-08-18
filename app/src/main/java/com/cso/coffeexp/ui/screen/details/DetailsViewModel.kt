package com.cso.coffeexp.ui.screen.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cso.coffeexp.data.Coffee
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
            DetailsEvent.OnInit -> getHomeContent()
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