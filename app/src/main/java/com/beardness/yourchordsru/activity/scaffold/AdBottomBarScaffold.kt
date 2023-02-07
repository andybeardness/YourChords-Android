package com.beardness.yourchordsru.activity.scaffold

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.beardness.yourchordsru.navigation.Navigation
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

@Composable
fun AdBottomBarScaffold(
    setupNavController: (NavHostController) -> Unit,
) {
    Scaffold(
        backgroundColor = YourChordsRuTheme.colors.background,
        bottomBar = {
            AdBottomBanner()
        }
    ) { paddings ->
        Navigation(
            paddings = paddings,
            setupNavController = setupNavController,
        )
    }
}