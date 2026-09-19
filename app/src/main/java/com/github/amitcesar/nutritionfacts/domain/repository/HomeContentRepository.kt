package com.github.amitcesar.nutritionfacts.domain.repository

import com.github.amitcesar.nutritionfacts.domain.model.HomeContent

interface HomeContentRepository {
    suspend fun getHomeContent(): HomeContent
}