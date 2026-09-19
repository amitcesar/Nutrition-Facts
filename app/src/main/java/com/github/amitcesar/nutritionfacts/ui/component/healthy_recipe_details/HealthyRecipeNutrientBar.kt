package com.github.amitcesar.nutritionfacts.ui.component.healthy_recipe_details

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.github.amitcesar.nutritionfacts.R
import com.github.amitcesar.nutritionfacts.ui.theme.Primary
import com.github.amitcesar.nutritionfacts.ui.theme.SurfaceElement
import com.github.amitcesar.nutritionfacts.ui.theme.TabelaNutricionalTheme
import com.github.amitcesar.nutritionfacts.ui.theme.TabelaNutricionalTheme.sizing
import com.github.amitcesar.nutritionfacts.ui.theme.Typography
import kotlin.math.roundToInt


private const val DEFAULT_MAX_NUTRIENT_VALUE = 100f
private const val DEFAULT_TOTAL_NUTRIENT_BARS = 6

@Composable
fun HealthyRecipeNutrientBar(
    modifier: Modifier = Modifier,
    name: String,
    value: Float,
    maxValue: Float = DEFAULT_MAX_NUTRIENT_VALUE
) {
    Column(
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = modifier.weight(1f),
                text = name,
                style = Typography.headlineMedium
            )
            Text(
                text = stringResource(R.string.valor_g, value),
            )
            Spacer(modifier = Modifier.height(sizing.sm))
        }
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(sizing.sm)
        ) {
            repeat(DEFAULT_TOTAL_NUTRIENT_BARS) { barPosition ->
                val shouldFillNutrientBar = shouldFillNutrientBar(
                    barPosition = barPosition,
                    value = value,
                    maxValue = maxValue
                )

                Canvas(
                    modifier = Modifier
                        .weight(1f)
                        .height(sizing.sm)
                ) {
                    drawRoundRect(
                        color = if(shouldFillNutrientBar) Primary else SurfaceElement,
                        cornerRadius = CornerRadius(x = 8.dp.toPx(), y = 8.dp.toPx()),
                    )
                }
            }
        }
    }
}

private fun shouldFillNutrientBar(
    barPosition: Int,
    value: Float,
    maxValue: Float
) : Boolean = barPosition <= (value * DEFAULT_TOTAL_NUTRIENT_BARS / maxValue).roundToInt() - 1


//TESTE DE PREVIEW
class NutrientValueProvider: PreviewParameterProvider<Float> {
    override val values: Sequence<Float>
        get() = sequenceOf(0f, 15.13f, 25f, 50f, 85f, 100f, 200f)
}

@Preview(showBackground = true)
@Composable
private fun HealthyRecipeNutrientBarPreview(
    @PreviewParameter(NutrientValueProvider::class) value: Float
) {
    TabelaNutricionalTheme {
        HealthyRecipeNutrientBar(
            modifier = Modifier.padding(16.dp),
            name = "Proteínas",
            value = value,
        )
    }
}

