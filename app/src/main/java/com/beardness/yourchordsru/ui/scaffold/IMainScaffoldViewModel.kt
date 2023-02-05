package com.beardness.yourchordsru.ui.scaffold

import androidx.navigation.NavHostController

interface IMainScaffoldViewModel {
    fun setupNavigator(
        navHostController: NavHostController,
        openDrawer: () -> Unit,
    )
    fun navigateHome()
}