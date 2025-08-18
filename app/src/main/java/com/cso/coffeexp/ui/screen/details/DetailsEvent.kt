package com.cso.coffeexp.ui.screen.details

sealed interface DetailsEvent {
    data object OnInit: DetailsEvent
}