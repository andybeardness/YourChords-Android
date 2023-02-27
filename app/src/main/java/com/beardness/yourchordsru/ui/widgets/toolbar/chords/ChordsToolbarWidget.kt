package com.beardness.yourchordsru.ui.widgets.toolbar.chords

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme
import com.beardness.yourchordsru.ui.widgets.settings.colors.MiniColorPickerLineWidget
import com.beardness.yourchordsru.ui.widgets.toolbar.classic.ToolbarIconWidget
import com.beardness.yourchordsru.utils.extensions.buttonColorByCondition

@Composable
fun ChordsToolbarWidget(
    title: String,
    onClickNavigation: () -> Unit,
    isExpanded: Boolean,
    onClickExpand: () -> Unit,
    onClickTextIncrease: () -> Unit,
    isIncreaseButtonActive: Boolean,
    onClickResetFontSize: () -> Unit,
    isResetFontSizeButtonActive: Boolean,
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
    val heightValue =
        if (isExpanded) {
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

    val increaseButtonColor =
        YourChordsRuTheme.colors.text
            .buttonColorByCondition(condition = isIncreaseButtonActive)

    val resetButtonColor =
        YourChordsRuTheme.colors.text
            .buttonColorByCondition(condition = isResetFontSizeButtonActive)

    val decreaseButtonColor =
        YourChordsRuTheme.colors.text
            .buttonColorByCondition(condition = isDecreaseButtonActive)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = height)
            .background(color = YourChordsRuTheme.colors.card)
            .padding(
                horizontal = YourChordsRuTheme.dimens.dp8,
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = YourChordsRuTheme.dimens.dp64)
                .background(color = YourChordsRuTheme.colors.card),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ToolbarIconWidget(
                icon = Icons.Rounded.ChevronLeft,
                iconDescription = "",
                iconColor = YourChordsRuTheme.colors.text,
                onClick = onClickNavigation,
            )

            Text(
                modifier = Modifier
                    .weight(weight = 1f),
                text = title,
                color = YourChordsRuTheme.colors.text,
                style = YourChordsRuTheme.typography.titleAtToolbar,
            )

            if (isExpanded) {
                ToolbarIconWidget(
                    icon = Icons.Rounded.ExpandLess,
                    iconDescription = "",
                    iconColor = YourChordsRuTheme.colors.text,
                    onClick = onClickExpand,
                )
            } else {
                ToolbarIconWidget(
                    icon = Icons.Rounded.ExpandMore,
                    iconDescription = "",
                    iconColor = YourChordsRuTheme.colors.text,
                    onClick = onClickExpand,
                )
            }
        }

        if (isExpanded) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = YourChordsRuTheme.dimens.dp64)
                    .background(color = YourChordsRuTheme.colors.card),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                ToolbarIconWidget(
                    icon = Icons.Rounded.TextDecrease,
                    iconDescription = "",
                    iconColor = decreaseButtonColor,
                    onClick = onClickTextDecrease,
                )
                ToolbarIconWidget(
                    icon = Icons.Rounded.Spellcheck,
                    iconDescription = "",
                    iconColor = resetButtonColor,
                    onClick = onClickResetFontSize,
                )
                ToolbarIconWidget(
                    icon = Icons.Rounded.TextIncrease,
                    iconDescription = "",
                    iconColor = increaseButtonColor,
                    onClick = onClickTextIncrease,
                )
            }

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