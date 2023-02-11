package com.beardness.yourchordsru.activity.scaffold

import androidx.navigation.NavHostController
import com.beardness.yourchordsru.presentation.screens.settings.types.ThemeSettingsType
import kotlinx.coroutines.flow.Flow

interface IMainActivityViewModel {
    val theme: Flow<ThemeSettingsType>
    fun setupNavController(navHostController: NavHostController)
}