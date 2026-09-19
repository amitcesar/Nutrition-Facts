package com.github.amitcesar.nutritionfacts.data.repository

import com.github.amitcesar.nutritionfacts.data.datasource.local.HealthyRecipeLocalDataSource
import com.github.amitcesar.nutritionfacts.data.model.HealthyRecipe
import com.github.amitcesar.nutritionfacts.domain.repository.HealthyRecipeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class HealthyRecipeRepositoryImpl(
    private val localDataSource: HealthyRecipeLocalDataSource
) : HealthyRecipeRepository {
    override suspend fun getHealthyRecipeById(id: String): HealthyRecipe? =
        withContext(Dispatchers.Default) {
            localDataSource.getHealthyRecipeById(id)
        }

    override suspend fun checkIsFavorite(id: String): Boolean =
        withContext(Dispatchers.Default) {
            localDataSource.checkIsFavorite(id)
        }

    override suspend fun updateIsFavorite(id: String, isFavorite: Boolean) =
        withContext(Dispatchers.Default){
            localDataSource.updateIsFavorite(id, isFavorite)
        }
}