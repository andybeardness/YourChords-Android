package com.beardness.yourchordsru.presentation.core.settings

import androidx.compose.ui.graphics.Color
import com.beardness.yourchordsru.presentation.core.dto.ChordsViewCoreDto
import com.beardness.yourchordsru.presentation.screens.dto.types.AuthorsSortType
import com.beardness.yourchordsru.utils.sorttype.SongsSortType
import kotlinx.coroutines.flow.Flow

interface ISettingsCore {
    val themeCode: Flow<Int>
    val chordsView: Flow<ChordsViewCoreDto>
    val authorsSortType: Flow<AuthorsSortType>
    val songsSortType: Flow<SongsSortType>
    suspend fun setupThemeCode(code: Int)
    suspend fun setupBackgroundColor(color: Color)
    suspend fun setupTextColor(color: Color)
    suspend fun setupChordsColor(color: Color)
    suspend fun setupFontSize(size: Int)
    suspend fun setupAuthorsSortType(authorsSortType: AuthorsSortType)
    suspend fun setupSongsSortType(songsSortType: SongsSortType)
}