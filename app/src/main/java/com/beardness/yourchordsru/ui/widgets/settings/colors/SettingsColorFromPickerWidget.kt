package com.beardness.yourchordsru.ui.widgets.settings.colors

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme
import com.beardness.yourchordsru.utils.extensions.clickableHapticNoRipple

@Composable
fun SettingsColorFromPickerWidget(
    color: Color,
    isActive: Boolean,
    onClick: () -> Unit,
) {
    val size =
        if (isActive) {
            YourChordsRuTheme.dimens.dp80
        } else {
            YourChordsRuTheme.dimens.dp64
        }

    val animatedSize by animateDpAsState(
        targetValue = size,
        animationSpec = tween(
            durationMillis = 200,
            easing = LinearOutSlowInEasing,
        )
    )

    val shape = RoundedCornerShape(size = YourChordsRuTheme.dimens.dp16)

    Spacer(
        modifier = Modifier
            .size(size = animatedSize)
            .border(
                width = YourChordsRuTheme.dimens.dp2,
                color = YourChordsRuTheme.colors.text.copy(alpha = .2f),
                shape = shape,
            )
            .background(
                color = color,
                shape = shape,
            )
            .clip(shape = shape)
            .clickableHapticNoRipple { onClick() },
    )
}

@Composable
@Preview
fun Preview_SettingsColorFromPickerWidget_0() {
    SettingsColorFromPickerWidget(
        color = Color(color = 0xFFFF0000),
        isActive = true,
        onClick = {},
    )
}

@Composable
@Preview
fun Preview_SettingsColorFromPickerWidget_1() {
    SettingsColorFromPickerWidget(
        color = Color(color = 0xFFFF0000),
        isActive = false,
        onClick = {},
    )
}