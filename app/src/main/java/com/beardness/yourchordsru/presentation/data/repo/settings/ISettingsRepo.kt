package com.beardness.yourchordsru.presentation.data.repo.settings

import com.beardness.yourchordsru.presentation.data.repo.dto.ChordsViewRepoDto
import kotlinx.coroutines.flow.Flow

interface ISettingsRepo {
    val themeCode: Flow<Int>
    val chordsView: Flow<ChordsViewRepoDto>
    val authorsSortTypeCode: Flow<Int>
    val songsSortTypeCode: Flow<Int>
    suspend fun setupThemeCode(code: Int)
    suspend fun setupBackgroundColor(color: Long)
    suspend fun setupTextColor(color: Long)
    suspend fun setupChordsColor(color: Long)
    suspend fun setupFontSize(size: Int)
    suspend fun updateAuthorsSortType(code: Int)
    suspend fun updateSongsSortType(code: Int)
}