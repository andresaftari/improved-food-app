package com.andresaftari.foodiezz.core.domain

import com.andresaftari.foodiezz.core.domain.model.Category
import com.andresaftari.foodiezz.core.domain.repo.DomainMealRepository
import com.andresaftari.foodiezz.core.domain.usecase.DomainUseCase

class DomainInteractor(private val domainMealRepository: DomainMealRepository) : DomainUseCase {
    override fun getAllCategories() = domainMealRepository.getAllCategories()

    override fun getFavoritedCategories() = domainMealRepository.getFavoritedCategories()

    override fun setFavoriteCategories(category: Category, state: Boolean) =
        domainMealRepository.setFavoriteCategories(category, state)
}