package com.beardness.yourchordsru.helpers.colors.html

import androidx.compose.ui.graphics.Color
import com.beardness.yourchordsru.presentation.view.screen.chords.types.ChordsViewMode
import com.beardness.yourchordsru.theme.app.colors.appColors
import javax.inject.Inject

class HtmlColorHelper @Inject constructor(
) : HtmlColorHelperProtocol {

    override fun choose(mode: ChordsViewMode): HtmlColors =
        HtmlColors(
            backgroundColor = backgroundColor(mode = mode),
            textColor = textColor(mode = mode),
            chordsColor = chordsColor(mode = mode),
        )

    private fun backgroundColor(mode: ChordsViewMode): Color =
        when (mode) {
            ChordsViewMode.LIGHT_BLUE -> appColors.white
            ChordsViewMode.LIGHT_CORAL -> appColors.white
            ChordsViewMode.DARK_ORANGE -> appColors.black
            ChordsViewMode.DARK_GREEN -> appColors.black
            ChordsViewMode.SEPIA -> appColors.sepia
        }

    private fun textColor(mode: ChordsViewMode): Color =
        when (mode) {
            ChordsViewMode.LIGHT_BLUE -> appColors.black
            ChordsViewMode.LIGHT_CORAL -> appColors.black
            ChordsViewMode.DARK_ORANGE -> appColors.white
            ChordsViewMode.DARK_GREEN -> appColors.white
            ChordsViewMode.SEPIA -> appColors.black
        }

    private fun chordsColor(mode: ChordsViewMode): Color =
        when (mode) {
            ChordsViewMode.LIGHT_BLUE -> appColors.blue
            ChordsViewMode.LIGHT_CORAL -> appColors.coral
            ChordsViewMode.DARK_ORANGE -> appColors.orange
            ChordsViewMode.DARK_GREEN -> appColors.green
            ChordsViewMode.SEPIA -> appColors.black
        }
}