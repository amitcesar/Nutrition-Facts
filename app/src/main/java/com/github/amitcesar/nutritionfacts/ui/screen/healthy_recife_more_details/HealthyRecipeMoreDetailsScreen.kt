package com.github.amitcesar.nutritionfacts.ui.screen.healthy_recife_more_details

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.amitcesar.nutritionfacts.R
import com.github.amitcesar.nutritionfacts.data.mock.mockHealthyRecipes
import com.github.amitcesar.nutritionfacts.data.model.HealthyRecipe
import com.github.amitcesar.nutritionfacts.ui.component.healthy_recipe_more_details.HealthyRecipeNutrientInfo
import com.github.amitcesar.nutritionfacts.ui.theme.SurfaceElement
import com.github.amitcesar.nutritionfacts.ui.theme.TabelaNutricionalTheme
import com.github.amitcesar.nutritionfacts.ui.theme.TabelaNutricionalTheme.sizing
import com.github.amitcesar.nutritionfacts.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HealthyRecipeMoreDetailsScreen(
    modifier: Modifier = Modifier,
    healthyRecipe: HealthyRecipe,
    sheetState: SheetState,
    onDismiss: () -> Unit
) {

    val isPreview = LocalInspectionMode.current

    LaunchedEffect(key1 = Unit) {
        if (isPreview) sheetState.expand()
    }

    ModalBottomSheet(
        modifier = modifier,
        contentColor = MaterialTheme.colorScheme.onBackground,
        onDismissRequest = { onDismiss() },
        sheetState = sheetState,
        dragHandle = {
            Box(
                modifier = Modifier.padding(sizing.md)
            ) {
                Canvas(
                    modifier = Modifier
                        .fillMaxWidth(0.2f)
                        .height(sizing.sm)
                ) {
                    drawRoundRect(
                        color = SurfaceElement,
                        cornerRadius = CornerRadius(x = 8.dp.toPx(), y = 8.dp.toPx())
                    )
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = sizing.md)
                .padding(bottom = sizing.lg),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(sizing.md)
        ) {
            Text(
                text = stringResource(R.string.mais_detalhes),
                style = Typography.headlineMedium,
            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.calories
            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.proteins

            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.carbohydrates,
            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.fiber,
                isSubNutrient = true
            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.sugar,
                isSubNutrient = true
            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.totalFat,
            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.saturatedFat,
                isSubNutrient = true
            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.transFat,
                isSubNutrient = true
            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.cholesterol,
            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.sodium,
            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.potassium,
            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.calcium,
            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.iron,
            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.magnesium,
            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.vitaminC,
            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.vitaminD,
            )
            HealthyRecipeNutrientInfo(
                nutrient = healthyRecipe.vitaminB6,
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun HealthyRecipeMoreDetailsScreenPreview() {
    TabelaNutricionalTheme() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(SurfaceElement),

            ) {
            HealthyRecipeMoreDetailsScreen(
                sheetState = rememberModalBottomSheetState(),
                healthyRecipe = mockHealthyRecipes.first(),
                onDismiss = {}
            )
        }
    }
}