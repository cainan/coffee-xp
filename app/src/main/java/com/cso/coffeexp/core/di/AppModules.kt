package com.cso.coffeexp.core.di

import com.cso.coffeexp.ui.screen.details.DetailsViewModel
import com.cso.coffeexp.ui.screen.home.HomeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

object AppModules {

    val uiModule = module {
        viewModelOf(::HomeViewModel)
        viewModelOf(::DetailsViewModel)
    }

}