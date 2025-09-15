package com.cso.coffeexp.ui.screen.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cso.coffeexp.domain.model.Coffee
import com.cso.coffeexp.domain.repository.CoffeeRepository
import com.cso.coffeexp.domain.usecase.InsertCoffeeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val insertCoffeeUseCase: InsertCoffeeUseCase,
    private val coffeeRepository: CoffeeRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailsUIState(isLoading = false, coffee = Coffee()))
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: DetailsEvent) {
        when (event) {
            is DetailsEvent.FindCoffeeById -> findCoffeeById(event.coffeeId)
            is DetailsEvent.SaveCoffee -> saveCoffee(event.onSuccess)

            // handle textFields
            is DetailsEvent.OnCoffeeNameChanged -> onCoffeeNameChanged(event.newName)
            is DetailsEvent.OnCoffeeGradeChanged -> onCoffeeGradeChanged(event.newGrade)
            is DetailsEvent.OnCoffeeMethodChanged -> onCoffeeMethodChanged(event.newMethod)
            is DetailsEvent.OnCoffeeNotesChanged -> onCoffeeNotesChanged(event.newNotes)
        }
    }


    private fun saveCoffee(onSuccess: () -> Unit) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true)
            }

            insertCoffeeUseCase.invoke(_uiState.value.coffee)
            _uiState.update {
                it.copy(isLoading = false)
            }

            onSuccess()
        }
    }

    private fun findCoffeeById(id: Long) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true)
            }

            _uiState.update {
                it.copy(
                    isLoading = false,
                    coffee = coffeeRepository.getCoffeeById(id) ?: Coffee()
                )
            }
        }
    }


    // Handle TextView

    private fun onCoffeeNameChanged(newName: String) {
        _uiState.update {
            it.copy(coffee = it.coffee.copy(name = newName))
        }
    }

    private fun onCoffeeGradeChanged(newGrade: String) {
        runCatching {
            newGrade.toFloat()
            _uiState.update {
                it.copy(coffee = it.coffee.copy(grade = newGrade.toFloat()))
            }
        }
    }

    private fun onCoffeeMethodChanged(newMethod: String) {
        _uiState.update {
            it.copy(coffee = it.coffee.copy(method = newMethod))
        }
    }

    private fun onCoffeeNotesChanged(newNotes: String) {
        _uiState.update {
            it.copy(coffee = it.coffee.copy(notes = newNotes))
        }
    }

}