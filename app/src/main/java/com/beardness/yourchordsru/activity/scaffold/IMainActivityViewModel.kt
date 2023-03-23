package com.beardness.yourchordsru.activity.scaffold

import androidx.navigation.NavHostController
import com.beardness.yourchordsru.presentation.screens.settings.types.ThemeSettingsType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface IMainActivityViewModel {
    val theme: Flow<ThemeSettingsType>
    val keepScreenAwake: StateFlow<Boolean>
    fun setupNavController(navHostController: NavHostController)
    fun setupFavorites()
}