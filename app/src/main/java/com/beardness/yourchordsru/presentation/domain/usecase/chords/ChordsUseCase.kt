package com.beardness.yourchordsru.presentation.domain.usecase.chords

import com.beardness.yourchordsru.presentation.domain.core.settings.SettingsCoreProtocol
import com.beardness.yourchordsru.presentation.domain.core.songs.SongsCoreProtocol
import javax.inject.Inject

class ChordsUseCase @Inject constructor(
    private val songsCore: SongsCoreProtocol,
    private val settingsCore: SettingsCoreProtocol,
) : ChordsUseCaseProtocol {

    override val fontSize = settingsCore.fontSize
    override val viewMode = settingsCore.viewMode

    override val isMaxFontSize = settingsCore.isMaxFontSize
    override val isMinFontSize = settingsCore.isMinFontSize

    override suspend fun chords(authorId: Int, songId: Int): String? =
        songsCore
            .song(authorId = authorId, songId = songId)
            ?.chords

    override suspend fun increaseFontSize() {
        settingsCore.increaseFontSize()
    }

    override suspend fun decreaseFontSize() {
        settingsCore.decreaseFontSize()
    }

    override suspend fun swapViewMode() {
        settingsCore.nextViewMode()
    }
}