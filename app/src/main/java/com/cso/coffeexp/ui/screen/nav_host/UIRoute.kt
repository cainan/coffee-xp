package com.cso.coffeexp.ui.screen.nav_host

import kotlinx.serialization.Serializable

@Serializable
sealed interface UIRoute {

    @Serializable
    data object Home : UIRoute

    @Serializable
    data class Details(val coffeeId: String) : UIRoute

}