package com.beardness.yourchordsru.presentation.view.compose.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Tag
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.beardness.yourchordsru.theme.YourChordsRuTheme

@Composable
fun SongAvatarComponent(
    imageVector: ImageVector = Icons.Rounded.Tag,
    tint: Color = MaterialTheme.colors.onBackground,
) {
    Box(
        modifier = Modifier
            .size(size = YourChordsRuTheme.dimens.dp48)
            .clip(shape = RoundedCornerShape(percent = 50))
            .padding(all = YourChordsRuTheme.dimens.dp12),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            modifier = Modifier
                .size(size = YourChordsRuTheme.dimens.dp32),
            imageVector = imageVector,
            contentDescription = null,
            tint = tint,
        )
    }
}