package com.github.amitcesar.nutritionfacts.domain.repository

import com.github.amitcesar.nutritionfacts.data.model.HealthyRecipe

interface HealthyRecipeRepository {
    suspend fun getHealthyRecipeById(id: String): HealthyRecipe?
    suspend fun checkIsFavorite(id: String): Boolean
    suspend fun updateIsFavorite(id: String, isFavorite: Boolean)
}