package com.cso.coffeexp.ui.screen.details

sealed interface DetailsEvent {
    data class FindCoffeeById(val coffeeId: String) : DetailsEvent
    object SaveCoffee : DetailsEvent
}