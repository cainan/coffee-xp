package com.cso.coffeexp.core.di

import com.cso.coffeexp.data.repository.CoffeeRepositoryImpl
import com.cso.coffeexp.domain.repository.CoffeeRepository
import com.cso.coffeexp.domain.usecase.InsertCoffeeUseCase
import com.cso.coffeexp.ui.screen.details.DetailsViewModel
import com.cso.coffeexp.ui.screen.home.HomeViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

object AppModules {

    val uiModule = module {
        viewModelOf(::HomeViewModel)
        viewModelOf(::DetailsViewModel)
    }

    val domainModule = module {
        factory { InsertCoffeeUseCase(get()) }
    }

    val dataModule = module {
        singleOf(::CoffeeRepositoryImpl) {
            bind<CoffeeRepository>()
        }
    }
}