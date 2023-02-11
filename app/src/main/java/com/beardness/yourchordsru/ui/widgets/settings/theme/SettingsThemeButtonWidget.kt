package com.beardness.yourchordsru.ui.widgets.settings.theme

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme
import com.beardness.yourchordsru.utils.extensions.clickableWithoutRipple

@Composable
fun SettingsThemeButtonWidget(
    title: String,
    isActive: Boolean,
    onClick: () -> Unit,
) {
    val backgroundColor =
        if (isActive) {
            YourChordsRuTheme.colors.blue
        } else {
            Color.Transparent
        }

    val titleColor =
        if (isActive) {
            Color.White
        } else {
            YourChordsRuTheme.colors.text
        }

    val animatedColor by animateColorAsState(
        targetValue = backgroundColor,
        animationSpec = tween(
            durationMillis = 200,
            easing = LinearOutSlowInEasing,
        )
    )

    val shape = RoundedCornerShape(size = YourChordsRuTheme.dimens.dp8)

    Box(
        modifier = Modifier
            .background(
                color = animatedColor,
                shape = shape,
            )
            .clip(shape = shape)
            .clickableWithoutRipple { onClick() }
            .padding(
                horizontal = YourChordsRuTheme.dimens.dp16,
                vertical = YourChordsRuTheme.dimens.dp8,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = title,
            color = titleColor,
        )
    }
}