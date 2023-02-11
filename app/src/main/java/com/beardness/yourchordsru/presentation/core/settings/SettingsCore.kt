package com.beardness.yourchordsru.presentation.core.settings

import androidx.compose.ui.graphics.Color
import com.beardness.yourchordsru.presentation.core.dto.coreDto
import com.beardness.yourchordsru.presentation.data.repo.settings.ISettingsRepo
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SettingsCore @Inject constructor(
    private val settingsRepo: ISettingsRepo,
) : ISettingsCore {

    override val chordsView =
        settingsRepo
            .chordsView
            .map { chordsView -> chordsView.coreDto() }

    override suspend fun setupBackgroundColor(color: Color) {
       settingsRepo.setupBackgroundColor(color = color.value.toLong())
    }

    override suspend fun setupTextColor(color: Color) {
        settingsRepo.setupTextColor(color = color.value.toLong())
    }

    override suspend fun setupChordsColor(color: Color) {
        settingsRepo.setupChordsColor(color = color.value.toLong())
    }

    override suspend fun setupFontSize(size: Int) {
        settingsRepo.setupFontSize(size = size)
    }
}