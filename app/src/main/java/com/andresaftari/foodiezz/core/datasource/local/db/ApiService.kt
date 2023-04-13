package com.andresaftari.foodiezz.core.datasource.local.db

import com.andresaftari.foodiezz.core.datasource.remote.response.ListCategoryResponse
import retrofit2.http.GET

interface ApiService {
    @GET("categories.php")
    suspend fun getCategories(): ListCategoryResponse
}