package com.andresaftari.foodiezz.core.datasource.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ListCategoryResponse(
    @field:SerializedName("categories")
    @Expose
    val categories: List<CategoryResponse>
) : Serializable