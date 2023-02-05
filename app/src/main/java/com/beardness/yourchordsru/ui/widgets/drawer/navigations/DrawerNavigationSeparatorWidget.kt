package com.beardness.yourchordsru.ui.widgets.drawer.navigations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

@Composable
fun DrawerNavigationSeparatorWidget() {
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = YourChordsRuTheme.dimens.dp1)
            .padding(horizontal = YourChordsRuTheme.dimens.dp32)
            .background(color = YourChordsRuTheme.colors.text.copy(alpha = .2f))
    )
}

@Composable
@Preview(showBackground = true)
fun Preview_DrawerNavigationSeparatorWidget_0() {
    DrawerNavigationSeparatorWidget()
}