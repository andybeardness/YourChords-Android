package com.beardness.yourchordsru.presentation.domain.core.settings

import kotlinx.coroutines.flow.Flow

interface SettingsCoreProtocol {
    val fontSize: Flow<Int>
    val viewMode: Flow<Int>
    val isMaxFontSize: Flow<Boolean>
    val isMinFontSize: Flow<Boolean>
    suspend fun increaseFontSize()
    suspend fun decreaseFontSize()
    suspend fun nextViewMode()
}