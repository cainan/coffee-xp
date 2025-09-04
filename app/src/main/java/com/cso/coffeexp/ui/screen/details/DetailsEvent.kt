package com.cso.coffeexp.ui.screen.details

sealed interface DetailsEvent {
    data class FindCoffeeById(val coffeeId: String) : DetailsEvent
    data class SaveCoffee(val onBackPressed: () -> Unit) : DetailsEvent

    // Handling textViews
    data class OnCoffeeNameChanged(val newName: String) : DetailsEvent
    data class OnCoffeeMethodChanged(val newMethod: String) : DetailsEvent
    data class OnCoffeeGradeChanged(val newGrade: String) : DetailsEvent
    data class OnCoffeeNotesChanged(val newNotes: String) : DetailsEvent
}