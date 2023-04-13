package com.andresaftari.foodiezz.ui.view.favs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.andresaftari.foodiezz.core.domain.usecase.DomainUseCase

class FavoriteViewModel(domainUseCase: DomainUseCase) : ViewModel() {
    val getFavoriteList = domainUseCase.getFavoritedCategories().asLiveData()
}