package com.andresaftari.foodiezz.core.datasource.local

import com.andresaftari.foodiezz.core.datasource.local.db.MealDao
import com.andresaftari.foodiezz.core.datasource.local.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val mealDao: MealDao) {
    fun getAllCategories(): Flow<List<CategoryEntity>> = mealDao.getAllCategories()

    fun getFavoritedCategories(): Flow<List<CategoryEntity>> = mealDao.getFavoritedMeal()

    fun insertCategories(
        listCategory: List<CategoryEntity>
    ) = mealDao.insertCategory(listCategory)

    fun setFavoriteCategories(
        category: CategoryEntity,
        state: Boolean
    ) {
        category.isFavorited = state
        mealDao.updateFavoritedMeal(category)
    }
}