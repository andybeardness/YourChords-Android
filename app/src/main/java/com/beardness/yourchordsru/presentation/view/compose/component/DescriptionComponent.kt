package com.beardness.yourchordsru.presentation.view.compose.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.beardness.yourchordsru.theme.AppTheme

@Composable
fun DescriptionComponent(
    modifier: Modifier,
    title: String,
    descriptions: List<String>,
) {
    Column(
        modifier = modifier
            .padding(horizontal = AppTheme.dimens.dp16),
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = title,
            maxLines = 2,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleMedium,
        )

        descriptions.forEach { description ->
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = description,
                maxLines = 1,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = .5f),
                style = MaterialTheme.typography.bodyMedium,
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