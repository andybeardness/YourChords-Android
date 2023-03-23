package com.beardness.yourchordsru.activity

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.beardness.yourchordsru.activity.scaffold.IMainActivityViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.navigation.navigator.INavigator
import com.beardness.yourchordsru.presentation.core.favorite.IFavoriteCore
import com.beardness.yourchordsru.presentation.core.screen.awake.IScreenAwakeCore
import com.beardness.yourchordsru.presentation.core.settings.ISettingsCore
import com.beardness.yourchordsru.presentation.screens.settings.types.themeSettingsType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val settingsCore: ISettingsCore,
    private val favoriteCore: IFavoriteCore,
    private val screenAwakeCore: IScreenAwakeCore,
    private val navigator: INavigator,
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope
): ViewModel(), IMainActivityViewModel {

    override val theme =
        settingsCore
            .themeCode
            .map { code -> code.themeSettingsType() }

    override val keepScreenAwake =
        screenAwakeCore
            .screenAwakeFlow

    override fun setupNavController(navHostController: NavHostController) {
        navigator.setupNavController(controller = navHostController)
    }

    override fun setupFavorites() {
        ioCoroutineScope.launch {
            favoriteCore.load()
        }
    }
}