package com.github.amitcesar.nutritionfacts.ui.component.healthy_recipe_more_details


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.amitcesar.nutritionfacts.R
import com.github.amitcesar.nutritionfacts.data.mock.mockHealthyRecipes
import com.github.amitcesar.nutritionfacts.data.model.HealthyRecipeNutrient
import com.github.amitcesar.nutritionfacts.ui.theme.TabelaNutricionalTheme
import com.github.amitcesar.nutritionfacts.ui.theme.TabelaNutricionalTheme.sizing
import com.github.amitcesar.nutritionfacts.ui.theme.Typography


@Composable
fun HealthyRecipeNutrientInfo(
    modifier: Modifier = Modifier,
    isSubNutrient: Boolean = false,
    nutrient: HealthyRecipeNutrient
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f).padding(start = if(isSubNutrient) sizing.md else sizing.x0),
            text = stringResource(id = nutrient.nameRes),
            style = if(isSubNutrient) Typography.bodyMedium else Typography.headlineSmall
        )
        Text(
            text = stringResource(R.string.valor_nutriente, nutrient.value, nutrient.unit.symbol),
            style = Typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HealthyRecipeNutrientInfoPreview() {
    TabelaNutricionalTheme {
        Column {
            HealthyRecipeNutrientInfo(
                modifier = Modifier.padding(16.dp),
                nutrient = mockHealthyRecipes.first().calories
            )
            HealthyRecipeNutrientInfo(
                modifier = Modifier.padding(horizontal = 16.dp).padding(bottom = 16.dp),
                isSubNutrient = true,
                nutrient = mockHealthyRecipes.first().fiber
            )
        }
    }
}