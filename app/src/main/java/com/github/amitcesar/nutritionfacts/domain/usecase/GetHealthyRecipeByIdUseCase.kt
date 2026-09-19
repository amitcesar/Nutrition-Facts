package com.github.amitcesar.nutritionfacts.domain.usecase

import com.github.amitcesar.nutritionfacts.data.model.HealthyRecipe
import com.github.amitcesar.nutritionfacts.domain.repository.HealthyRecipeRepository

class GetHealthyRecipeByIdUseCase(
    private val repository: HealthyRecipeRepository
) {

    suspend operator fun invoke(id: String): HealthyRecipe? = repository.getHealthyRecipeById(id)
}