package com.beardness.yourchordsru.presentation.view.compose.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.beardness.yourchordsru.theme.AppTheme

@Composable
fun IconComponent(
    imageVector: ImageVector,
    tint: Color,
) {
    Box(
        modifier = Modifier
            .size(size = AppTheme.dimens.dp64)
            .padding(all = AppTheme.dimens.dp16)
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
@Preview
fun Preview_IconComponent() {
    IconComponent(
        imageVector = Icons.Rounded.ArrowForwardIos,
        tint = AppTheme.colors.white,
    )
}