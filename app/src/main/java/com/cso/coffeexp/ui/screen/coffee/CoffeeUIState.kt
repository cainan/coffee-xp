package com.cso.coffeexp.ui.screen.coffee

import com.cso.coffeexp.data.Coffee

data class CoffeeUIState(
    val isLoading: Boolean = false,
    val coffeeList: List<Coffee>? = null,
)
