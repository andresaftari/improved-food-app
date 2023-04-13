package com.andresaftari.foodiezz.ui.view.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.andresaftari.foodiezz.core.domain.usecase.DomainUseCase

class HomeViewModel(domainUseCase: DomainUseCase) : ViewModel() {
    val category = domainUseCase.getAllCategories().asLiveData()
}