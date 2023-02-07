package com.beardness.yourchordsru.presentation.screens.home.scaffold.drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme
import com.beardness.yourchordsru.ui.widgets.drawer.appavatar.AppAvatarWidget
import com.beardness.yourchordsru.ui.widgets.drawer.navigations.DrawerNavigationWidget

@Composable
fun MainDrawer(
    navigateHome: () -> Unit,
    navigateFavorite: () -> Unit,
    navigateSettings: () -> Unit,
    navigateAbout: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = YourChordsRuTheme.colors.card),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AppAvatarWidget()

        DrawerNavigationWidget(
            navigateHome = navigateHome,
            navigateFavorite = navigateFavorite,
            navigateSettings = navigateSettings,
            navigateAbout = navigateAbout,
        )
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_MainDrawer_0() {
    MainDrawer(
        navigateHome = {},
        navigateFavorite = {},
        navigateSettings = {},
        navigateAbout = {},
    )
}