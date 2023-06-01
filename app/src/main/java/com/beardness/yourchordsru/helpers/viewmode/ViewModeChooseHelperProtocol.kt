package com.beardness.yourchordsru.helpers.viewmode

import com.beardness.yourchordsru.presentation.view.screen.chords.types.ChordsViewMode

interface ViewModeChooseHelperProtocol {
    fun choose(current: ChordsViewMode): ChordsViewMode
}
