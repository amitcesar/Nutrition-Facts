package com.github.amitcesar.nutritionfacts.data.model


import java.util.UUID




data class WellnessNews(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val imageRes: Int,
    val readTimeInMinutes: Int,
    val tags: List<WellnessNewsTag>
)

