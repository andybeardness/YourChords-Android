package com.beardness.yourchordsru.ui.scaffold

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.beardness.yourchordsru.navigation.navigator.INavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScaffoldViewModel @Inject constructor(
    private val navigator: INavigator,
): ViewModel(), IMainScaffoldViewModel {
    override fun setupNavigator(
        navHostController: NavHostController,
        openDrawer: () -> Unit,
    ) {
        navigator.setupNavController(controller = navHostController)
        navigator.setupDrawerController(openDrawer = openDrawer)
    }

    override fun navigateHome() {
        navigator.home()
    }
}