package com.cso.coffeexp.ui.screen.details

import com.cso.coffeexp.data.Coffee

data class DetailsUIState(
    val isLoading: Boolean = false,
    val coffee: Coffee,
)
