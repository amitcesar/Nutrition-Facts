package com.github.amitcesar.nutritionfacts.domain.usecase

import com.github.amitcesar.nutritionfacts.domain.repository.HealthyRecipeRepository

class IsHealthyRecipeFavoriteUseCase(
    private val repository: HealthyRecipeRepository
) {
    suspend operator fun invoke(id: String): Boolean = repository.checkIsFavorite(id= id)
}