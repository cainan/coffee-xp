package com.cso.coffeexp.ui.screen.home

import com.cso.coffeexp.domain.model.Coffee

sealed interface HomeEvent {
    data object OnInit : HomeEvent
    data class OnRemoveCoffee(val coffee: Coffee) : HomeEvent
    data class OnSearch(val query: String) : HomeEvent
}