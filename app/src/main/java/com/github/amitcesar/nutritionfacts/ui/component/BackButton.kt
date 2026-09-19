package com.github.amitcesar.nutritionfacts.ui.component

import androidx.compose.animation.core.animateFloatAsState

import androidx.compose.animation.core.tween
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.github.amitcesar.nutritionfacts.R
import com.github.amitcesar.nutritionfacts.ui.theme.Background
import com.github.amitcesar.nutritionfacts.ui.theme.TabelaNutricionalTheme
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun BackButton(modifier: Modifier = Modifier, onClick: () -> Unit ) {

    var isPressed by remember { mutableStateOf(false)}

    val scale by animateFloatAsState(
        targetValue =  if (isPressed) 1.4f else 1.0f,
        animationSpec = tween(durationMillis = 150)
    )


    LaunchedEffect(key1 = isPressed) {
        if (isPressed){
            delay(150.milliseconds)
            isPressed = false
        }
    }


    IconButton(
       modifier = modifier,
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = Background
        ),
        onClick = {
            isPressed = true
            onClick()
        }
    ) {
        Icon(
            modifier = Modifier.scale(scale),
            painter = painterResource(R.drawable.ic_arrow_left),
            contentDescription = stringResource(R.string.botao_voltar)
        )
    }
}

@Preview
@Composable
private fun BackButtonPreview() {
    TabelaNutricionalTheme() {
        BackButton { }
    }
}