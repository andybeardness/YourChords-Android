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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme
import com.beardness.yourchordsru.utils.extensions.clickableHaptic

@Composable
fun SliderElementWidget(
    char: Char,
    charColor: Color,
    onClickChar: () -> Unit,
) {
    val shape = RoundedCornerShape(size = YourChordsRuTheme.dimens.dp8)

    Box(
        modifier = Modifier
            .size(size = YourChordsRuTheme.dimens.dp48)
            .padding(
                top = YourChordsRuTheme.dimens.dp8,
                start = YourChordsRuTheme.dimens.dp4,
                end = YourChordsRuTheme.dimens.dp4,
            )
            .clip(shape = shape)
            .background(
                color = YourChordsRuTheme.colors.card,
            )
            .background(
                color = charColor.copy(alpha = .2f)
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