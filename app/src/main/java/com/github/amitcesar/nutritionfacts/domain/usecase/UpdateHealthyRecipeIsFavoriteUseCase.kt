package com.github.amitcesar.nutritionfacts.domain.usecase

import com.github.amitcesar.nutritionfacts.domain.repository.HealthyRecipeRepository

class UpdateHealthyRecipeIsFavoriteUseCase(
    private val repository: HealthyRecipeRepository
) {

    suspend operator fun invoke(id: String, isFavorite: Boolean) {
        repository.updateIsFavorite(id, isFavorite)
    }
}