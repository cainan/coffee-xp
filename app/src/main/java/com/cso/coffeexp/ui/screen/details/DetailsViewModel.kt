package com.cso.coffeexp.ui.screen.details

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cso.coffeexp.domain.model.Coffee
import com.cso.coffeexp.domain.repository.CoffeeRepository
import com.cso.coffeexp.domain.usecase.InsertCoffeeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private const val TAG = "DetailsViewModel"

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
            is DetailsEvent.UpdateCoffee -> updateCoffee(event.onSuccess)
            is DetailsEvent.OnShowBottomSheet -> onShowBottomSheet(event.show)
            is DetailsEvent.OnImageSelectedFromGallery -> onImageSelectedFromGallery(event.imageUri)

            // handle textFields
            is DetailsEvent.OnCoffeeNameChanged -> onCoffeeNameChanged(event.newName)
            is DetailsEvent.OnCoffeeGradeChanged -> onCoffeeGradeChanged(event.newGrade)
            is DetailsEvent.OnCoffeeMethodChanged -> onCoffeeMethodChanged(event.newMethod)
            is DetailsEvent.OnCoffeeNotesChanged -> onCoffeeNotesChanged(event.newNotes)
        }
    }

    private fun onImageSelectedFromGallery(imageUri: String) {
        _uiState.update {
            it.copy(coffee = it.coffee.copy(imageUrl = imageUri))
        }
    }

    private fun onShowBottomSheet(show: Boolean) {
        _uiState.update {
            it.copy(showBottomSheet = show)
        }
    }

    private fun updateCoffee(onSuccess: () -> Unit) {

        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true)
            }

            val updateCoffee = coffeeRepository.updateCoffee(_uiState.value.coffee)
            Log.d(TAG, "updateCoffee: $updateCoffee")

            onSuccess()

        }
    }


    private fun saveCoffee(onSuccess: () -> Unit) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true)
            }

            insertCoffeeUseCase.invoke(_uiState.value.coffee)

            onSuccess()

        }
    }

    private fun findCoffeeById(id: Long?) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true)
            }

            val coffeeToDisplay =
                id?.let { coffeeRepository.getCoffeeById(id) ?: Coffee() } ?: Coffee()

            _uiState.update {
                it.copy(
                    isLoading = false,
                    coffee = coffeeToDisplay
                )
            }
        }
    }

    fun clearUiState() {
        _uiState.update {
            it.copy(
                isLoading = false,
                coffee = Coffee()
            )
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