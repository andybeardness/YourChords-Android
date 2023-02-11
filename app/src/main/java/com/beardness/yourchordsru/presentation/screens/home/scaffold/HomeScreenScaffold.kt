package com.beardness.yourchordsru.presentation.screens.home.scaffold

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.beardness.yourchordsru.presentation.screens.home.scaffold.drawer.MainDrawer
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme
import kotlinx.coroutines.launch

@Composable
fun HomeScreenScaffold(
    scaffoldState: ScaffoldState,
    onClickNavigateHome: () -> Unit,
    onClickNavigateSettings: () -> Unit,
    content: @Composable (PaddingValues) -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()

    val closeDrawer = {
        coroutineScope.launch {
            scaffoldState.drawerState.close()
        }
    }

    Scaffold(
        backgroundColor = YourChordsRuTheme.colors.background,
        scaffoldState = scaffoldState,
        drawerContent = {
            MainDrawer(
                navigateHome = {
                    onClickNavigateHome()
                    closeDrawer()
                },
                navigateFavorite = {},
                navigateSettings = {
                    onClickNavigateSettings()
                    closeDrawer()
                },
                navigateAbout = {},
            )
        },
        drawerElevation = YourChordsRuTheme.dimens.dp32
    ) { paddingValues ->
        content(paddingValues)
    }
}