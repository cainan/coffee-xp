package com.cso.coffeexp.ui.screen.details

import com.cso.coffeexp.domain.model.Coffee

data class DetailsUIState(
    val isLoading: Boolean = false,
    val coffee: Coffee = Coffee(),
)
