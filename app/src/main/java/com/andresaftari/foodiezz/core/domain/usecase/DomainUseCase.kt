package com.andresaftari.foodiezz.core.domain.usecase

import com.andresaftari.foodiezz.core.datasource.Resource
import com.andresaftari.foodiezz.core.domain.model.Category
import kotlinx.coroutines.flow.Flow

interface DomainUseCase {
    fun getAllCategories(): Flow<Resource<List<Category>>>
    fun getFavoritedCategories(): Flow<List<Category>>
    fun setFavoriteCategories(category: Category, state: Boolean)
}