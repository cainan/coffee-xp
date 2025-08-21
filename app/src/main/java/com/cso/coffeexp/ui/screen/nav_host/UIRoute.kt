package com.cso.coffeexp.ui.screen.nav_host

import com.cso.coffeexp.data.Coffee
import kotlinx.serialization.Serializable

@Serializable
sealed interface UIRoute {

    @Serializable
    data object Home : UIRoute

    @Serializable
    data class Details(val coffee: String) : UIRoute

}