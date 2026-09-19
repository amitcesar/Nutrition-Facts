package com.github.amitcesar.nutritionfacts.domain.usecase

import com.github.amitcesar.nutritionfacts.domain.model.HomeContent
import com.github.amitcesar.nutritionfacts.domain.repository.HomeContentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetHomeContentUseCase(
    private val homeContentRepository: HomeContentRepository
) {

    operator fun invoke(): Flow<HomeContent> = flow {
        emit(homeContentRepository.getHomeContent())
    }
}