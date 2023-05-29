package com.beardness.yourchordsru.presentation.view.compose.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.beardness.yourchordsru.theme.YourChordsRuTheme

@Composable
fun DescriptionComponent(
    modifier: Modifier,
    title: String,
    descriptions: List<String>,
) {
    Column(
        modifier = modifier
            .padding(horizontal = YourChordsRuTheme.dimens.dp16),
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = title,
            maxLines = 2,
            color = Color.White,
            fontSize = 16.sp,
        )

        descriptions.forEach { description ->
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = description,
                maxLines = 1,
                color = Color.White.copy(alpha = .1f),
                fontSize = 14.sp,
            )
        }
    }
}

@Composable
@Preview
fun Preview_DescriptionComponent() {
    DescriptionComponent(
        modifier = Modifier.fillMaxWidth(),
        title = "King & Joker",
        descriptions = listOf(
            "Songs : 1488",
            "Rating : 99 999",
        ),
    )
}