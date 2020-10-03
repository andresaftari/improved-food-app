package com.andresaftari.foodiezz.view.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.andresaftari.core.domain.usecase.IMealUseCase

class FavoriteViewModel(iMealUseCase: IMealUseCase) : ViewModel() {
    val getFavoriteList = iMealUseCase.getFavoriteCategories().asLiveData()
}