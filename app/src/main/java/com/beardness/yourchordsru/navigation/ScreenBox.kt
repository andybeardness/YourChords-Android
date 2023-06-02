package com.beardness.yourchordsru.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.beardness.yourchordsru.theme.AppTheme

@Composable
fun ScreenBox(
    paddingValues: PaddingValues?,
    screen: @Composable () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues ?: PaddingValues(all = AppTheme.dimens.dp0)),
    ) {
        screen()
    }
}