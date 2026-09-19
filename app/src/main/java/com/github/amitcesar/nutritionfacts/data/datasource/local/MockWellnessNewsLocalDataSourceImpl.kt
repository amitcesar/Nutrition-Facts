package com.github.amitcesar.nutritionfacts.data.datasource.local

import com.github.amitcesar.nutritionfacts.data.mock.mockWellnessNews
import com.github.amitcesar.nutritionfacts.data.model.WellnessNews

class MockWellnessNewsLocalDataSourceImpl: WellnessNewsLocalDataSource {
    override suspend fun getAllWellnessNews(): List<WellnessNews> = mockWellnessNews
}