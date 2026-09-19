package com.github.amitcesar.nutritionfacts.data.datasource.local

import com.github.amitcesar.nutritionfacts.data.mock.mockHealthyRecipes
import com.github.amitcesar.nutritionfacts.data.model.HealthyRecipe
import java.util.UUID

class MockHealthyRecipeLocalDataSourceImpl : HealthyRecipeLocalDataSource {

    override suspend fun getAllHealthyRecipes(): List<HealthyRecipe> = mockHealthyRecipes

    private val healthyRecipeFavoriteIdList = mutableListOf<String>()


    override suspend fun getHealthyRecipeById(id: String): HealthyRecipe? {
        return mockHealthyRecipes.find { healthyRecipe -> healthyRecipe.id == UUID.fromString(id) }
    }


    override suspend fun checkIsFavorite(id: String): Boolean =
       healthyRecipeFavoriteIdList.contains(id)


    override suspend fun updateIsFavorite(id: String, isFavorite: Boolean) {

        if (isFavorite) healthyRecipeFavoriteIdList.add(id)
        else
            healthyRecipeFavoriteIdList.remove(id)

    }

}
