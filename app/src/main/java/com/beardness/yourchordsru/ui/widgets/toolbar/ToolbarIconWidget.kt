package com.beardness.yourchordsru.ui.widgets.toolbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

@Composable
fun ToolbarIconWidget(
    icon: ImageVector,
    iconDescription: String,
    iconColor: Color,
    onClick: () -> Unit,
) {
    Icon(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(percent = 50))
            .clickable { onClick() }
            .padding(all = YourChordsRuTheme.dimens.dp8)
            .size(size = YourChordsRuTheme.dimens.dp32),
        imageVector = icon,
        contentDescription = iconDescription,
        tint = iconColor,
    )
}