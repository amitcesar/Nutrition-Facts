package com.github.amitcesar.nutritionfacts.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.amitcesar.nutritionfacts.ui.theme.Primary
import com.github.amitcesar.nutritionfacts.ui.theme.Typography

@Composable
fun PrimaryButton(modifier: Modifier = Modifier, text: String ,onClick: ()-> Unit) {
    ElevatedButton(
        modifier = modifier,
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = Primary
        ),
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 4.dp
        ),
        shape = RoundedCornerShape(size = 16.dp),
        onClick = onClick
    ) {
        Text(text = text, style = Typography.bodyLarge, color = MaterialTheme.colorScheme.onPrimary)
    }
}