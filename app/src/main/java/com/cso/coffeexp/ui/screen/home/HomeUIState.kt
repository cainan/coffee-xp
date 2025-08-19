package com.cso.coffeexp.ui.screen.home

import com.cso.coffeexp.data.Coffee

data class HomeUIState(
    val isLoading: Boolean = false,
    val coffeeList: List<Coffee>? = null,
)
