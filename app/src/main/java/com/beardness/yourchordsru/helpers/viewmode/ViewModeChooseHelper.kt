package com.beardness.yourchordsru.helpers.viewmode

import com.beardness.yourchordsru.presentation.view.screen.chords.types.ChordsViewMode
import javax.inject.Inject

class ViewModeChooseHelper @Inject constructor(
) : ViewModeChooseHelperProtocol {

    override fun choose(current: ChordsViewMode): ChordsViewMode =
        when (current) {
            ChordsViewMode.LIGHT_BLUE -> ChordsViewMode.LIGHT_CORAL
            ChordsViewMode.LIGHT_CORAL -> ChordsViewMode.DARK_ORANGE
            ChordsViewMode.DARK_ORANGE -> ChordsViewMode.DARK_GREEN
            ChordsViewMode.DARK_GREEN -> ChordsViewMode.SEPIA
            ChordsViewMode.SEPIA -> ChordsViewMode.LIGHT_BLUE
        }
}