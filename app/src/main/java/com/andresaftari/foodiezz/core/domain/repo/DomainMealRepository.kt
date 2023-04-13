package com.andresaftari.foodiezz.core.domain.repo

import com.andresaftari.foodiezz.core.datasource.Resource
import com.andresaftari.foodiezz.core.domain.model.Category
import kotlinx.coroutines.flow.Flow

interface DomainMealRepository {
    fun getAllCategories(): Flow<Resource<List<Category>>>
    fun getFavoritedCategories(): Flow<List<Category>>
    fun setFavoriteCategories(category: Category, state: Boolean)
}