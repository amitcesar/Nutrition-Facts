package com.github.amitcesar.nutritionfacts.ui.screen.home

import com.github.amitcesar.nutritionfacts.domain.model.HomeContent

data class HomeUiState(
    val isLoading : Boolean = false,
    val homeContent: HomeContent? = null,
    val userName: String? = null
)
