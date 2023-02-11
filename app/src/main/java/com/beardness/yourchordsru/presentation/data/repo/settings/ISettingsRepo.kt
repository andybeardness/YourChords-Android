package com.beardness.yourchordsru.presentation.data.repo.settings

import com.beardness.yourchordsru.presentation.data.repo.dto.ChordsViewRepoDto
import kotlinx.coroutines.flow.Flow

interface ISettingsRepo {
    val chordsView: Flow<ChordsViewRepoDto>
    suspend fun setupBackgroundColor(color: Long)
    suspend fun setupTextColor(color: Long)
    suspend fun setupChordsColor(color: Long)
    suspend fun setupFontSize(size: Int)
}