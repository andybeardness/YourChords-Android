package com.beardness.yourchordsru.presentation.domain.core.settings

import com.beardness.yourchordsru.helpers.fontsize.FontSizeHelperProtocol
import com.beardness.yourchordsru.helpers.viewmode.ViewModeHelperProtocol
import com.beardness.yourchordsru.presentation.data.storage.AppDataStoreProtocol
import com.beardness.yourchordsru.presentation.view.screen.chords.types.ChordsViewMode
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SettingsCore @Inject constructor(
    private val appDataStore: AppDataStoreProtocol,
    private val fontSizeHelper: FontSizeHelperProtocol,
    private val viewModeChooseHelper: ViewModeHelperProtocol,
) : SettingsCoreProtocol {

    companion object {
        private const val DEFAULT_VIEW_MODE = 0
        private const val DEFAULT_FONT_SIZE = 14
        private const val MAX_FONT_SIZE = 24
        private const val MIN_FONT_SIZE = 8
        private const val STEP_FONT_SIZE = 2
    }

    override val fontSize =
        appDataStore
            .fontSize
            .map { fontSize ->
                fontSizeHelper.fontSizeOrDefault(
                    fontSize = fontSize,
                    max = MAX_FONT_SIZE,
                    min = MIN_FONT_SIZE,
                    default = DEFAULT_FONT_SIZE,
                )
            }

    override val viewMode =
        appDataStore
            .viewMode
            .map { viewMode ->
                viewModeChooseHelper.viewModeCodeOrDefault(
                    current = viewMode,
                    size = ChordsViewMode.values().size,
                    default = DEFAULT_VIEW_MODE
                )
            }

    override val isMaxFontSize = fontSize.map { fontSize -> fontSize >= MAX_FONT_SIZE }

    override val isMinFontSize = fontSize.map { fontSize -> fontSize <= MIN_FONT_SIZE }

    override suspend fun increaseFontSize() {
        val increased = fontSizeHelper.increase(
            fontSize = appDataStore.fontSize(),
            step = STEP_FONT_SIZE,
            max = MAX_FONT_SIZE,
            min = MIN_FONT_SIZE,
            default = DEFAULT_FONT_SIZE
        )

        appDataStore.updateFontSize(update = increased)
    }

    override suspend fun decreaseFontSize() {
        val decreased = fontSizeHelper.decrease(
            fontSize = appDataStore.fontSize(),
            step = STEP_FONT_SIZE,
            max = MAX_FONT_SIZE,
            min = MIN_FONT_SIZE,
            default = DEFAULT_FONT_SIZE,
        )

        appDataStore.updateFontSize(update = decreased)
    }

    override suspend fun nextViewMode() {
        val next = viewModeChooseHelper.newViewModeCode(
            current = appDataStore.viewModeCode(),
            size = ChordsViewMode.values().size,
            default = DEFAULT_VIEW_MODE,
        )

        appDataStore.updateViewMode(update = next)
    }
}