package com.github.amitcesar.nutritionfacts.data.repository

import com.github.amitcesar.nutritionfacts.data.datasource.local.HealthyRecipeLocalDataSource
import com.github.amitcesar.nutritionfacts.data.datasource.local.WellnessNewsLocalDataSource
import com.github.amitcesar.nutritionfacts.domain.model.HomeContent
import com.github.amitcesar.nutritionfacts.domain.repository.HomeContentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class HomeContentRepositoryImpl(
    private val healthyRecipeLocalDataSource: HealthyRecipeLocalDataSource,
    private val wellnessNewsLocalDataSource: WellnessNewsLocalDataSource
): HomeContentRepository {
    override suspend fun getHomeContent(): HomeContent = withContext(Dispatchers.Default) {
        val wellnessNewsList = wellnessNewsLocalDataSource.getAllWellnessNews()
        val healthyRecipeList = healthyRecipeLocalDataSource.getAllHealthyRecipes()


        delay(timeMillis = 1_500)

        return@withContext HomeContent(
            wellnessNewsList = wellnessNewsList,
            healthyRecipeList = healthyRecipeList
        )
    }
}