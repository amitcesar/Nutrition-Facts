package com.github.amitcesar.nutritionfacts.ui.screen.home

sealed interface HomeEvent {
    data object OnInit: HomeEvent
}