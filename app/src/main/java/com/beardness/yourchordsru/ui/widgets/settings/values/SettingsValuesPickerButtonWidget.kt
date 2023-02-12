package com.beardness.yourchordsru.ui.widgets.settings.values

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme
import com.beardness.yourchordsru.utils.extensions.clickableHapticNoRipple

@Composable
fun SettingsValuesPickerButtonWidget(
    icon: ImageVector,
    color: Color,
    onClick: () -> Unit,
) {
    val shape = RoundedCornerShape(percent = 50)

    val animatedColor by animateColorAsState(
        targetValue = color,
        animationSpec = tween(
            durationMillis = 200,
            easing = LinearOutSlowInEasing,
        )
    )

    Icon(
        modifier = Modifier
            .background(
                color = animatedColor,
                shape = shape,
            )
            .clip(shape = shape)
            .clickableHapticNoRipple { onClick() }
            .padding(all = YourChordsRuTheme.dimens.dp8)
            .size(size = YourChordsRuTheme.dimens.dp32),
        imageVector = icon,
        contentDescription = "",
        tint = Color.White,
    )
}