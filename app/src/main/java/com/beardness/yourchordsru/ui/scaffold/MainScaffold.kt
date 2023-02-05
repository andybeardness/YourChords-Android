package com.beardness.yourchordsru.ui.scaffold

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.beardness.yourchordsru.navigation.Navigation
import com.beardness.yourchordsru.ui.scaffold.drawer.MainDrawer
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme
import kotlinx.coroutines.launch

@Composable
fun MainScaffold(viewModel: IMainScaffoldViewModel) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        backgroundColor = YourChordsRuTheme.colors.background,
        scaffoldState = scaffoldState,
        drawerContent = {
            MainDrawer(
                navigateHome = {
                    viewModel.navigateHome()
                    coroutineScope.launch {
                        scaffoldState.drawerState.close()
                    }
                },
                navigateFavorite = {},
                navigateSettings = {},
                navigateAbout = {},
            )
        },
        drawerElevation = YourChordsRuTheme.dimens.dp4
    ) { paddings ->
        Navigation(
            paddings = paddings,
            setupNavController = { navHostController ->
                viewModel.setupNavigator(navHostController = navHostController)
            }
        )
    }
}