package com.andresaftari.foodiezz.core.datasource.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "category")
data class CategoryEntity(
    @PrimaryKey
    val idCategory: String,
    val strCategory: String?,
    val strCategoryDescription: String?,
    val strCategoryThumb: String,
    var isFavorited: Boolean
): Parcelable