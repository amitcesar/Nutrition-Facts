package com.github.amitcesar.nutritionfacts.ui.component.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

import com.github.amitcesar.nutritionfacts.R
import com.github.amitcesar.nutritionfacts.data.model.WellnessNews
import com.github.amitcesar.nutritionfacts.data.model.WellnessNewsTag
import com.github.amitcesar.nutritionfacts.ui.theme.TabelaNutricionalTheme
import com.github.amitcesar.nutritionfacts.ui.theme.TabelaNutricionalTheme.sizing
import com.github.amitcesar.nutritionfacts.ui.theme.Typography
import java.util.UUID




@Composable
fun WellnessNewsCard(modifier: Modifier = Modifier, wellnessNews: WellnessNews) {
    Column(modifier = modifier) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = wellnessNews.imageRes),
            contentDescription = stringResource(R.string.imagem_noticia_saude_em_foco)
        )
        LazyRow(
            modifier = Modifier.padding(top = sizing.sm),
            horizontalArrangement = Arrangement.spacedBy(sizing.xs)
        ) {

            items(wellnessNews.tags.size) { index ->
                Text(
                    modifier = Modifier
                        .border(
                            width = sizing.x1,
                            color = MaterialTheme.colorScheme.onSurface,
                            shape = RoundedCornerShape(size = sizing.xs)
                        )
                        .padding(horizontal = sizing.sm),
                    style = Typography.titleSmall.copy(fontSize = 12.sp),
                    text = wellnessNews.tags[index].description,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = sizing.md),
            text = wellnessNews.title,
            style = Typography.titleSmall,
            minLines = 3,
            maxLines = 4,
            overflow = TextOverflow.Ellipsis
            )
        Text(
            text = stringResource(
                R.string.tempo_de_leitura_da_noticia,
                wellnessNews.readTimeInMinutes
            ),
            style = Typography.titleSmall.copy(color = MaterialTheme.colorScheme.onSecondary)
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun WellnessNewsCardPreview() {
    TabelaNutricionalTheme {
        WellnessNewsCard(
            modifier = Modifier
                .padding(sizing.md)
                .width(sizing.x4l),
            wellnessNews = WellnessNews(
                title = "A importância da tabela nutricional na alimentação consciente",
                readTimeInMinutes = 5,
                imageRes = R.drawable.img_nutritional_news_1,
                tags = listOf(
                    WellnessNewsTag.WELLNESS,
                    WellnessNewsTag.NUTRITION,
                )
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WellnessNewsCardListPreview() {
    TabelaNutricionalTheme {
        LazyRow(
            modifier = Modifier.padding(sizing.md),
            horizontalArrangement = Arrangement.spacedBy(sizing.sm)
        ) {
            items(3) {
                WellnessNewsCard(
                    modifier = Modifier.width(sizing.x4l),
                    wellnessNews = WellnessNews(
                        title = "A importância da tabela nutricional na alimentação consciente",
                        readTimeInMinutes = 5,
                        imageRes = R.drawable.img_nutritional_news_1,
                        tags = listOf(
                            WellnessNewsTag.WELLNESS,
                            WellnessNewsTag.NUTRITION,
                        )
                    )
                )
            }
        }
    }
}