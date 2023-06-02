package com.beardness.yourchordsru.presentation.view.compose.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PersonOutline
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.beardness.yourchordsru.theme.AppTheme

@Composable
fun AvatarComponent(
    imageVector: ImageVector,
    tint: Color,
    color: Color,
) {
    Box(
        modifier = Modifier
            .size(size = AppTheme.dimens.dp32)
            .clip(shape = RoundedCornerShape(size = AppTheme.dimens.dp8))
            .background(color = color),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            modifier = Modifier
                .size(size = AppTheme.dimens.dp32),
            imageVector = imageVector,
            contentDescription = null,
            tint = tint,
        )
    }
}

@Composable
@Preview(name = "Blue", group = "Color")
fun Preview_AvatarComponent_ColorBlue() {
    AvatarComponent(
        imageVector = Icons.Rounded.PersonOutline,
        tint = AppTheme.colors.white,
        color = AppTheme.colors.blue,
    )
}

@Composable
@Preview(name = "Red", group = "Color")
fun Preview_AvatarComponent_ColorRed() {
    AvatarComponent(
        imageVector = Icons.Rounded.PersonOutline,
        tint = AppTheme.colors.white,
        color = AppTheme.colors.red,
    )
}

@Composable
@Preview(name = "Green", group = "Color")
fun Preview_AvatarComponent_ColorGreen() {
    AvatarComponent(
        imageVector = Icons.Rounded.PersonOutline,
        tint = AppTheme.colors.white,
        color = AppTheme.colors.green,
    )
}