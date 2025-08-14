package com.cso.coffeexp.ui.screen.coffee

sealed interface CoffeeEvent {
    data object OnInit: CoffeeEvent
}