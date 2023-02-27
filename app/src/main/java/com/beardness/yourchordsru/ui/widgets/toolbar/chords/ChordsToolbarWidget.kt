package com.beardness.yourchordsru.ui.widgets.toolbar.chords

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme
import com.beardness.yourchordsru.ui.widgets.settings.colors.MiniColorPickerLineWidget
import com.beardness.yourchordsru.ui.widgets.settings.fonts.MiniFontPickerLineWidget

@Composable
fun ChordsToolbarWidget(
    title: String,
    onClickNavigation: () -> Unit,
    isFavoriteSong: Boolean,
    onClickFavoriteSong: () -> Unit,
    isExpanded: Boolean,
    onClickExpand: () -> Unit,
    onClickTextIncrease: () -> Unit,
    isIncreaseButtonActive: Boolean,
    onClickTextDecrease: () -> Unit,
    isDecreaseButtonActive: Boolean,
    backgroundColorsTitle: String,
    backgroundColors: List<Color>,
    activeBackgroundColor: Color,
    onClickBackgroundColor: (Color) -> Unit,
    textColorsTitle: String,
    textColors: List<Color>,
    activeTextColor: Color,
    onClickTextColor: (Color) -> Unit,
    chordsColorsTitle: String,
    chordsColors: List<Color>,
    activeChordsColor: Color,
    onClickChordsColor: (Color) -> Unit,
) {
    val heightValue = if (isExpanded) {
        YourChordsRuTheme.dimens.dp64x5
    } else {
        YourChordsRuTheme.dimens.dp64
    }

    val height by animateDpAsState(
        targetValue = heightValue,
        animationSpec = tween(
            durationMillis = 300,
        ),
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = height)
            .background(color = YourChordsRuTheme.colors.card)
            .padding(
                horizontal = YourChordsRuTheme.dimens.dp8,
            )
    ) {
        BaseChordsToolbarWidget(
            title = title,
            onClickNavigation = onClickNavigation,
            isFavoriteSong = isFavoriteSong,
            onClickFavoriteSong = onClickFavoriteSong,
            isExpanded = isExpanded,
            onClickExpand = onClickExpand,
        )

        if (isExpanded) {
            MiniFontPickerLineWidget(
                title = "Text size",
                isIncreaseButtonActive = isIncreaseButtonActive,
                onClickTextIncrease = onClickTextIncrease,
                isDecreaseButtonActive = isDecreaseButtonActive,
                onClickTextDecrease = onClickTextDecrease,
            )

            MiniColorPickerLineWidget(
                title = backgroundColorsTitle,
                colors = backgroundColors,
                activeColor = activeBackgroundColor,
                onClickColor = onClickBackgroundColor,
            )

            MiniColorPickerLineWidget(
                title = textColorsTitle,
                colors = textColors,
                activeColor = activeTextColor,
                onClickColor = onClickTextColor,
            )

            MiniColorPickerLineWidget(
                title = chordsColorsTitle,
                colors = chordsColors,
                activeColor = activeChordsColor,
                onClickColor = onClickChordsColor,
            )
        }
    }
}