package com.beardness.yourchordsru.helpers.colors.html

import com.beardness.yourchordsru.presentation.view.screen.chords.types.ChordsViewMode

interface HtmlColorHelperProtocol {
    fun choose(mode: ChordsViewMode): HtmlColors
}
