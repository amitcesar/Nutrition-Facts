package com.github.amitcesar.nutritionfacts.data.datasource.local

import com.github.amitcesar.nutritionfacts.data.model.WellnessNews

interface WellnessNewsLocalDataSource {
    suspend fun getAllWellnessNews(): List<WellnessNews>
}