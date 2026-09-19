package com.github.amitcesar.nutritionfacts.core.di

import com.github.amitcesar.nutritionfacts.data.datasource.local.HealthyRecipeLocalDataSource
import com.github.amitcesar.nutritionfacts.data.datasource.local.MockHealthyRecipeLocalDataSourceImpl
import com.github.amitcesar.nutritionfacts.data.datasource.local.MockWellnessNewsLocalDataSourceImpl
import com.github.amitcesar.nutritionfacts.data.datasource.local.WellnessNewsLocalDataSource
import com.github.amitcesar.nutritionfacts.data.repository.HealthyRecipeRepositoryImpl
import com.github.amitcesar.nutritionfacts.data.repository.HomeContentRepositoryImpl
import com.github.amitcesar.nutritionfacts.domain.repository.HealthyRecipeRepository
import com.github.amitcesar.nutritionfacts.domain.repository.HomeContentRepository
import com.github.amitcesar.nutritionfacts.domain.usecase.GetHealthyRecipeByIdUseCase
import com.github.amitcesar.nutritionfacts.domain.usecase.GetHomeContentUseCase
import com.github.amitcesar.nutritionfacts.domain.usecase.IsHealthyRecipeFavoriteUseCase
import com.github.amitcesar.nutritionfacts.domain.usecase.UpdateHealthyRecipeIsFavoriteUseCase
import com.github.amitcesar.nutritionfacts.ui.screen.healthy_recipe_details.HealthyRecipeDetailsViewModel
import com.github.amitcesar.nutritionfacts.ui.screen.home.HomeViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

object AppModules {

    val uiModule = module {
        viewModelOf(::HomeViewModel)
        viewModelOf(::HealthyRecipeDetailsViewModel)
    }

    val domainModule = module {
        factory { GetHomeContentUseCase(get()) }
        factory { GetHealthyRecipeByIdUseCase(get()) }
        factory { IsHealthyRecipeFavoriteUseCase(get()) }
        factory { UpdateHealthyRecipeIsFavoriteUseCase(get()) }
    }

    val dataModule = module {
        singleOf(::MockWellnessNewsLocalDataSourceImpl) {
            bind<WellnessNewsLocalDataSource>()
        }

        singleOf(::MockHealthyRecipeLocalDataSourceImpl) {
            bind<HealthyRecipeLocalDataSource>()
        }

        singleOf(::HomeContentRepositoryImpl) {
            bind<HomeContentRepository>()
        }

        singleOf(::HealthyRecipeRepositoryImpl) {
            bind<HealthyRecipeRepository>()
        }
    }
}