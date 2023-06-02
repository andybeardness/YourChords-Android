package com.beardness.yourchordsru.presentation.view.compose.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.beardness.yourchordsru.theme.AppTheme

@Composable
@Deprecated(
    message = "Duplicate",
    replaceWith = ReplaceWith(
        expression = "AvatarComponent",
    ),
)
fun SongAvatarComponent(
    imageVector: ImageVector,
    tint: Color,
) {
    Box(
        modifier = Modifier
            .size(size = AppTheme.dimens.dp32)
            .clip(shape = RoundedCornerShape(size = AppTheme.dimens.dp8))
            .background(color = tint),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            modifier = Modifier
                .size(size = AppTheme.dimens.dp32),
            imageVector = imageVector,
            contentDescription = null,
            tint = AppTheme.colors.white,
        )
    }
}