package com.beardness.yourchordsru.presentation.view.compose.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.beardness.yourchordsru.presentation.view.compose.component.ButtonComponent
import com.beardness.yourchordsru.presentation.view.entity.IconButton
import com.beardness.yourchordsru.theme.AppTheme
import com.beardness.yourchordsru.utils.extensions.clickableHapticNoRipple

@Composable
fun ToolbarWidget(
    title: String,
    navigationButton: IconButton,
    actionButton: List<IconButton>,
    onClickToolbarTitle: () -> Unit = {},
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = AppTheme.dimens.dp64)
            .background(color = MaterialTheme.colorScheme.background)
            .clickableHapticNoRipple(action = onClickToolbarTitle),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        ButtonComponent(
            imageVector = navigationButton.imageVector,
            tint = navigationButton.tint,
            onClick = navigationButton.onClick,
        )

        Text(
            modifier = Modifier
                .weight(weight = 1f),
            text = title,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.headlineMedium,
        )

        actionButton.forEach { button ->
            ButtonComponent(
                imageVector = button.imageVector,
                tint = button.tint,
                onClick = button.onClick,
            )
        }
    }
}