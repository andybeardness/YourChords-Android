package com.beardness.yourchordsru.activity

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.beardness.yourchordsru.activity.scaffold.IMainActivityViewModel
import com.beardness.yourchordsru.navigation.navigator.INavigator
import com.beardness.yourchordsru.presentation.core.settings.ISettingsCore
import com.beardness.yourchordsru.presentation.screens.settings.types.themeSettingsType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    settingsCore: ISettingsCore,
    private val navigator: INavigator,
): ViewModel(), IMainActivityViewModel {

    override val theme =
        settingsCore
            .themeCode
            .map { code -> code.themeSettingsType() }

    override fun setupNavController(navHostController: NavHostController) {
        navigator.setupNavController(controller = navHostController)
    }

}