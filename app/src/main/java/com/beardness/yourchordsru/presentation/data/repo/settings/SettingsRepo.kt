package com.beardness.yourchordsru.presentation.data.repo.settings

import com.beardness.yourchordsru.data.store.IAppDataStore
import com.beardness.yourchordsru.presentation.data.repo.dto.ChordsViewRepoDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class SettingsRepo @Inject constructor(
    private val appDataStore: IAppDataStore,
) : ISettingsRepo {

    override val themeCode: Flow<Int> =
        appDataStore
            .themeCode

    override val chordsView: Flow<ChordsViewRepoDto> =
        combine(
            appDataStore.backgroundColor,
            appDataStore.textColor,
            appDataStore.chordsColor,
            appDataStore.fontSize,
        ) { backgroundColor,
            textColor,
            chordsColor,
            fontSize ->

            ChordsViewRepoDto(
                backgroundColor = backgroundColor,
                textColor = textColor,
                chordsColor = chordsColor,
                fontSize = fontSize,
            )
        }

    override val songsSortTypeCode: Flow<Int> =
        appDataStore
            .songSortTypeCode

    override suspend fun setupThemeCode(code: Int) {
        appDataStore.setThemeCode(code = code)
    }

    override suspend fun setupBackgroundColor(color: Long) {
        appDataStore.setBackgroundColor(color = color)
    }

    override suspend fun setupTextColor(color: Long) {
        appDataStore.setTextColor(color = color)
    }

    override suspend fun setupChordsColor(color: Long) {
        appDataStore.setChordsColor(color = color)
    }

    override suspend fun setupFontSize(size: Int) {
        appDataStore.setFontSize(size = size)
    }

    override suspend fun updateSongsSortType(code: Int) {
        appDataStore.setSongsSortType(code = code)
    }
}