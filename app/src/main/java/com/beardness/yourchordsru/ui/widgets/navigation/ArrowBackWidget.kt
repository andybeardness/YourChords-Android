package com.beardness.yourchordsru.ui.widgets.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChevronLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme
import com.beardness.yourchordsru.utils.extensions.clickableHaptic

@Composable
fun ArrowBackWidget(
    onClick: () -> Unit,
) {
    Icon(
        modifier = Modifier
            .padding(all = YourChordsRuTheme.dimens.dp8)
            .clip(shape = RoundedCornerShape(percent = 50))
            .clickableHaptic { onClick() }
            .padding(all = YourChordsRuTheme.dimens.dp8)
            .size(size = YourChordsRuTheme.dimens.dp32),
        imageVector = Icons.Rounded.ChevronLeft,
        contentDescription = "",
        tint = YourChordsRuTheme.colors.text,
    )
}