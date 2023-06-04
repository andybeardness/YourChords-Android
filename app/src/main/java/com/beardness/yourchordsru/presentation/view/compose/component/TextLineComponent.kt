package com.beardness.yourchordsru.presentation.view.compose.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.beardness.yourchordsru.theme.AppTheme

@Composable
fun TextLineComponent(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = AppTheme.dimens.dp16,
                vertical = AppTheme.dimens.dp8,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
        )
    }
}