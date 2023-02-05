package com.beardness.yourchordsru.ui.widgets.drawer.navigations

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

@Composable
fun DrawerNavigationWidget(
    navigateHome: () -> Unit,
    navigateFavorite: () -> Unit,
    navigateSettings: () -> Unit,
    navigateAbout: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        DrawerNavigationElementWidget(
            icon = Icons.Rounded.Home,
            iconColor = YourChordsRuTheme.colors.text,
            iconDescription = "",
            title = "Home",
            onClick = navigateHome,
        )

        DrawerNavigationSeparatorWidget()

        DrawerNavigationElementWidget(
            icon = Icons.Rounded.Star,
            iconColor = YourChordsRuTheme.colors.yellow,
            iconDescription = "",
            title = "Favorite",
            onClick = navigateFavorite,
        )

        DrawerNavigationSeparatorWidget()

        DrawerNavigationElementWidget(
            icon = Icons.Rounded.Settings,
            iconColor = YourChordsRuTheme.colors.blue,
            iconDescription = "",
            title = "Settings",
            onClick = navigateSettings,
        )

        DrawerNavigationSeparatorWidget()

        DrawerNavigationElementWidget(
            icon = Icons.Rounded.Info,
            iconColor = YourChordsRuTheme.colors.cyan,
            iconDescription = "",
            title = "About",
            onClick = navigateAbout,
        )
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_DrawerNavigationWidget_0() {
    DrawerNavigationWidget(
        navigateHome = {},
        navigateFavorite = {},
        navigateSettings = {},
        navigateAbout = {},
    )
}