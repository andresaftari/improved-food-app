package com.andresaftari.foodiezz.core.datasource.remote.response

import java.io.Serializable

data class CategoryResponse(
    val idCategory: String,
    val strCategory: String?,
    val strCategoryDescription: String?,
    val strCategoryThumb: String,
    val isFavorited: Boolean
) : Serializable