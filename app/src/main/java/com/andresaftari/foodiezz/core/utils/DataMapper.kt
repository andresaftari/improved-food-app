package com.andresaftari.foodiezz.core.utils

import com.andresaftari.foodiezz.core.datasource.local.entity.CategoryEntity
import com.andresaftari.foodiezz.core.datasource.remote.response.CategoryResponse
import com.andresaftari.foodiezz.core.domain.model.Category

object DataMapper {
    fun mapCategoryResponseToCategoryEntity(
        listResponse: List<CategoryResponse>
    ): List<CategoryEntity> {
        val list = ArrayList<CategoryEntity>()

        listResponse.map {
            val category = CategoryEntity(
                it.idCategory,
                it.strCategory,
                it.strCategoryDescription,
                it.strCategoryThumb,
                it.isFavorited
            )
            list.add(category)
        }
        return list
    }

    fun mapCategoryEntityToDomain(
        listEntity: List<CategoryEntity>
    ) = listEntity.map {
        Category(
            it.idCategory,
            it.strCategory,
            it.strCategoryDescription,
            it.strCategoryThumb,
            it.isFavorited
        )
    }

    fun mapDomainToCategoryEntity(
        category: Category
    ) = CategoryEntity(
        category.idCategory,
        category.strCategory,
        category.strCategoryDescription,
        category.strCategoryThumb,
        category.isFavorited
    )
}