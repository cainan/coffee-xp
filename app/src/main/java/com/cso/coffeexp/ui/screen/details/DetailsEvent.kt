package com.cso.coffeexp.ui.screen.details

sealed interface DetailsEvent {
    data class FindCoffeeById(val coffeeId: Long?) : DetailsEvent
    data class SaveCoffee(val onSuccess: () -> Unit) : DetailsEvent
    data class UpdateCoffee(val onSuccess: () -> Unit) : DetailsEvent

    data class OnShowBottomSheet(val show: Boolean) : DetailsEvent
    data class OnImageSelectedFromGallery(val imageUri: String) : DetailsEvent

    // Handling textViews
    data class OnCoffeeNameChanged(val newName: String) : DetailsEvent
    data class OnCoffeeMethodChanged(val newMethod: String) : DetailsEvent
    data class OnCoffeeGradeChanged(val newGrade: String) : DetailsEvent
    data class OnCoffeeNotesChanged(val newNotes: String) : DetailsEvent
}