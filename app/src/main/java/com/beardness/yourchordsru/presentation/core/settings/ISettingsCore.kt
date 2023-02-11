package com.beardness.yourchordsru.presentation.core.settings

import androidx.compose.ui.graphics.Color
import com.beardness.yourchordsru.presentation.core.dto.ChordsViewCoreDto
import kotlinx.coroutines.flow.Flow

interface ISettingsCore {
    val themeCode: Flow<Int>
    val chordsView: Flow<ChordsViewCoreDto>
    suspend fun setupThemeCode(code: Int)
    suspend fun setupBackgroundColor(color: Color)
    suspend fun setupTextColor(color: Color)
    suspend fun setupChordsColor(color: Color)
    suspend fun setupFontSize(size: Int)
}