package com.beardness.yourchordsru.activity.scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

@Composable
fun AdBottomBanner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = YourChordsRuTheme.dimens.bottomBannerHeight)
            .background(color = YourChordsRuTheme.colors.card),
    )
}