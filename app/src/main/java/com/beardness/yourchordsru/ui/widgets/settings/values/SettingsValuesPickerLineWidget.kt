package com.beardness.yourchordsru.ui.widgets.settings.values

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.TextDecrease
import androidx.compose.material.icons.rounded.TextIncrease
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

@Composable
fun SettingsValuesPickerLineWidget(
    value: Int,
    isIncreaseButtonActive: Boolean,
    isDecreaseButtonActive: Boolean,
    onClickIncrease: () -> Unit,
    onClickDecrease: () -> Unit,
) {
    val increaseButtonColor =
        if (isIncreaseButtonActive) {
            YourChordsRuTheme.colors.blue
        } else {
            Color.Transparent
        }

    val decreaseButtonColor =
        if (isDecreaseButtonActive) {
            YourChordsRuTheme.colors.red
        } else {
            Color.Transparent
        }

    val onClickIncreaseButton =
        if (isIncreaseButtonActive) {
            onClickIncrease
        } else {
            { }
        }

    val onClickDecreaseButton =
        if (isDecreaseButtonActive) {
            onClickDecrease
        } else {
            { }
        }

    val animatedTextSize by animateIntAsState(
        targetValue = value,
        animationSpec = tween(
            durationMillis = 200,
            easing = LinearOutSlowInEasing,
        )
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = YourChordsRuTheme.dimens.dp64x2)
            .padding(
                vertical = YourChordsRuTheme.dimens.dp8,
                horizontal = YourChordsRuTheme.dimens.dp16
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        SettingsValuesPickerButtonWidget(
            icon = Icons.Rounded.TextDecrease,
            color = decreaseButtonColor,
            onClick = { onClickDecreaseButton() },
        )

        Text(
            modifier = Modifier
                .weight(weight = 1f)
                .animateContentSize(),
            text = "$value px",
            color = YourChordsRuTheme.colors.text,
            textAlign = TextAlign.Center,
            style = YourChordsRuTheme.typography.fontSizeTitleAtFontSizeSetting
                .copy(fontSize = animatedTextSize.sp)
        )

        SettingsValuesPickerButtonWidget(
            icon = Icons.Rounded.TextIncrease,
            color = increaseButtonColor,
            onClick = { onClickIncreaseButton() },
        )
    }
}