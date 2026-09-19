package com.github.amitcesar.nutritionfacts.ui.screen.healthy_recipe_details

import com.github.amitcesar.nutritionfacts.data.model.HealthyRecipe


data class HealthyRecipeDetailsUIState(
    val isLoading : Boolean = false,
    val healthyRecipe: HealthyRecipe? = null,
    val isFavorite: Boolean = false
)
