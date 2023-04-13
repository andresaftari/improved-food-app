package com.andresaftari.foodiezz.ui.view.detail

import androidx.lifecycle.ViewModel
import com.andresaftari.foodiezz.core.domain.model.Category
import com.andresaftari.foodiezz.core.domain.usecase.DomainUseCase

class DetailViewModel(private val domainUseCase: DomainUseCase) : ViewModel() {
    fun setFavorite(category: Category, state: Boolean) =
        domainUseCase.setFavoriteCategories(category, state)
}