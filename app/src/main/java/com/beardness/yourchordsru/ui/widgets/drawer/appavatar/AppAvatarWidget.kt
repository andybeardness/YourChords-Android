package com.beardness.yourchordsru.ui.widgets.drawer.appavatar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MusicNote
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

@Composable
fun AppAvatarWidget() {
    Box(
        modifier = Modifier
            .padding(all = YourChordsRuTheme.dimens.dp32)
            .size(size = YourChordsRuTheme.dimens.dp128)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        YourChordsRuTheme.colors.yellow,
                        YourChordsRuTheme.colors.orange,
                    ),
                ),
                shape = RoundedCornerShape(percent = 50)
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .size(size = YourChordsRuTheme.dimens.dp128)
                .padding(all = YourChordsRuTheme.dimens.dp16),
            imageVector = Icons.Rounded.MusicNote,
            contentDescription = "",
            tint = YourChordsRuTheme.colors.card,
        )
    }
}