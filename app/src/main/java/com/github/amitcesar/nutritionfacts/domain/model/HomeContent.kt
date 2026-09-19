package com.github.amitcesar.nutritionfacts.domain.model

import com.github.amitcesar.nutritionfacts.data.model.HealthyRecipe
import com.github.amitcesar.nutritionfacts.data.model.WellnessNews

data class HomeContent(
    val wellnessNewsList: List<WellnessNews>,
    val healthyRecipeList: List<HealthyRecipe>
)
