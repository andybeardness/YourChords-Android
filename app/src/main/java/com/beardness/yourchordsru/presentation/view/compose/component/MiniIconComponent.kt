package com.beardness.yourchordsru.presentation.view.compose.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.beardness.yourchordsru.theme.YourChordsRuTheme

@Composable
fun MiniIconComponent(
    imageVector: ImageVector,
    tint: Color,
) {
    Box(
        modifier = Modifier
            .size(size = YourChordsRuTheme.dimens.dp64)
            .padding(all = YourChordsRuTheme.dimens.dp16),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            modifier = Modifier
                .size(size = YourChordsRuTheme.dimens.dp16),
            imageVector = imageVector,
            contentDescription = null,
            tint = tint,
        )
    }
}

@Composable
@Preview
fun Preview_MiniIconComponent() {
    MiniIconComponent(
        imageVector = Icons.Rounded.ArrowForwardIos,
        tint = Color.White,
    )
}