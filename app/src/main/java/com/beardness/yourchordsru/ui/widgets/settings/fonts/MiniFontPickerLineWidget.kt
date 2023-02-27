package com.beardness.yourchordsru.ui.widgets.settings.fonts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.TextDecrease
import androidx.compose.material.icons.rounded.TextIncrease
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme
import com.beardness.yourchordsru.ui.widgets.toolbar.classic.ToolbarIconWidget
import com.beardness.yourchordsru.utils.extensions.buttonColorByCondition

@Composable
fun MiniFontPickerLineWidget(
    title: String,
    isIncreaseButtonActive: Boolean,
    onClickTextIncrease: () -> Unit,
    isDecreaseButtonActive: Boolean,
    onClickTextDecrease: () -> Unit,
) {
    val increaseButtonColor =
        YourChordsRuTheme.colors.text
            .buttonColorByCondition(condition = isIncreaseButtonActive)

    val decreaseButtonColor =
        YourChordsRuTheme.colors.text
            .buttonColorByCondition(condition = isDecreaseButtonActive)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = YourChordsRuTheme.dimens.dp64)
            .background(color = YourChordsRuTheme.colors.card),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        Text(
            text = title,
            color = YourChordsRuTheme.colors.text,
            style = YourChordsRuTheme.typography.titleAtSongScreenToolbar,
        )

        ToolbarIconWidget(
            icon = Icons.Rounded.TextDecrease,
            iconDescription = "",
            iconColor = decreaseButtonColor,
            onClick = onClickTextDecrease,
        )

        ToolbarIconWidget(
            icon = Icons.Rounded.TextIncrease,
            iconDescription = "",
            iconColor = increaseButtonColor,
            onClick = onClickTextIncrease,
        )
    }
}