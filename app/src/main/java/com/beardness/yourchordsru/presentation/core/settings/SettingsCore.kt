package com.beardness.yourchordsru.presentation.core.settings

import androidx.compose.ui.graphics.Color
import com.beardness.yourchordsru.presentation.core.dto.coreDto
import com.beardness.yourchordsru.presentation.data.repo.settings.ISettingsRepo
import com.beardness.yourchordsru.presentation.screens.dto.types.AuthorsSortType
import com.beardness.yourchordsru.presentation.screens.dto.types.codeToAuthorsSortType
import com.beardness.yourchordsru.utils.extensions.toLong
import com.beardness.yourchordsru.utils.sorttype.SongsSortType
import com.beardness.yourchordsru.utils.sorttype.codeToSongsSortType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SettingsCore @Inject constructor(
    private val settingsRepo: ISettingsRepo,
) : ISettingsCore {

    override val themeCode: Flow<Int> =
        settingsRepo
            .themeCode

    override val chordsView =
        settingsRepo
            .chordsView
            .map { chordsView -> chordsView.coreDto() }

    override val authorsSortType: Flow<AuthorsSortType> =
        settingsRepo
            .authorsSortTypeCode
            .map { code -> code.codeToAuthorsSortType() }

    override val songsSortType: Flow<SongsSortType> =
        settingsRepo
            .songsSortTypeCode
            .map { code -> code.codeToSongsSortType() }

    override suspend fun setupThemeCode(code: Int) {
        settingsRepo.setupThemeCode(code = code)
    }

    override suspend fun setupBackgroundColor(color: Color) {
       settingsRepo.setupBackgroundColor(color = color.toLong())
    }

    override suspend fun setupTextColor(color: Color) {
        settingsRepo.setupTextColor(color = color.toLong())
    }

    override suspend fun setupChordsColor(color: Color) {
        settingsRepo.setupChordsColor(color = color.toLong())
    }

    override suspend fun setupFontSize(size: Int) {
        settingsRepo.setupFontSize(size = size)
    }

    override suspend fun setupAuthorsSortType(authorsSortType: AuthorsSortType) {
        settingsRepo.updateAuthorsSortType(code = authorsSortType.code)
    }

    override suspend fun setupSongsSortType(songsSortType: SongsSortType) {
        settingsRepo.updateSongsSortType(code = songsSortType.code)
    }
}