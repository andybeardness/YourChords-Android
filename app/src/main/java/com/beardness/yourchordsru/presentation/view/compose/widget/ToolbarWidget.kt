package com.beardness.yourchordsru.presentation.view.compose.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.beardness.yourchordsru.presentation.view.compose.component.ButtonComponent
import com.beardness.yourchordsru.presentation.view.entity.IconButton
import com.beardness.yourchordsru.theme.YourChordsRuTheme

@Composable
fun ToolbarWidget(
    title: String,
    navigationButton: IconButton,
    actionButton: List<IconButton>,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = YourChordsRuTheme.dimens.dp64),
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
                color = Color.White,
            )

            actionButton.forEach { button ->
                ButtonComponent(
                    imageVector = button.imageVector,
                    tint = button.tint,
                    onClick = button.onClick,
                )
            }
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = YourChordsRuTheme.dimens.dp1)
                .background(color = Color.White.copy(alpha = .1f))
        )
    }
}