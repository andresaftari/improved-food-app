package com.andresaftari.foodiezz.ui.injections

import com.andresaftari.foodiezz.core.domain.DomainInteractor
import com.andresaftari.foodiezz.core.domain.usecase.DomainUseCase
import com.andresaftari.foodiezz.ui.view.detail.DetailViewModel
import com.andresaftari.foodiezz.ui.view.favs.FavoriteViewModel
import com.andresaftari.foodiezz.ui.view.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<DomainUseCase> { DomainInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
}