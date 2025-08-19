package com.cso.coffeexp.ui.screen.home

sealed interface HomeEvent {
    data object OnInit: HomeEvent
}