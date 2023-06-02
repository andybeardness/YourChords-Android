package com.beardness.yourchordsru.ad.compose.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.beardness.yourchordsru.ad.compose.component.AdBannerComponent
import com.beardness.yourchordsru.theme.AppTheme

@Composable
fun AdBannerWidget() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = AppTheme.dimens.dp64),
        contentAlignment = Alignment.Center,
    ) {
        AdBannerComponent()
    }
}