package com.beardness.yourchordsru.ui.widgets.slider

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme
import com.beardness.yourchordsru.utils.extensions.clickableHaptic

@Composable
fun SliderElementWidget(
    char: Char,
    onClickChar: () -> Unit,
) {
    val shape = RoundedCornerShape(percent = 50)

    Box(
        modifier = Modifier
            .size(size = YourChordsRuTheme.dimens.dp64)
            .padding(
                top = YourChordsRuTheme.dimens.dp8,
                start = YourChordsRuTheme.dimens.dp4,
                end = YourChordsRuTheme.dimens.dp4,
            )
            .background(
                color = YourChordsRuTheme.colors.card,
                shape = shape,
            )
            .clickableHaptic(action = onClickChar),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = char.uppercase(),
            color = YourChordsRuTheme.colors.text,
            style = YourChordsRuTheme.typography.charAtSlider,
        )
    }
}