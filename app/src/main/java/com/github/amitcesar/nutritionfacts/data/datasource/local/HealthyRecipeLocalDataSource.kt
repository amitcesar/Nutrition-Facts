package com.github.amitcesar.nutritionfacts.data.datasource.local

import com.github.amitcesar.nutritionfacts.data.model.HealthyRecipe

interface HealthyRecipeLocalDataSource {
    suspend fun getAllHealthyRecipes() : List<HealthyRecipe>
    suspend fun getHealthyRecipeById(id: String): HealthyRecipe?

    suspend fun checkIsFavorite(id: String): Boolean
    suspend fun updateIsFavorite(id: String, isFavorite: Boolean)
}

