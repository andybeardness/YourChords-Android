package com.beardness.yourchordsru.ad.compose.scaffold

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.beardness.yourchordsru.ad.compose.widget.AdBannerWidget

@Composable
fun AdScaffold(
    content: @Composable (paddingValues: PaddingValues?) -> Unit,
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = { AdBannerWidget() }
    ) { paddingValues ->
        content(paddingValues)
    }
}