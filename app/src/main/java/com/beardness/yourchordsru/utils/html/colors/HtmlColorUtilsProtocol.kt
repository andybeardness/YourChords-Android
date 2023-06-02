package com.beardness.yourchordsru.utils.html.colors

import com.beardness.yourchordsru.presentation.view.screen.chords.types.ChordsViewMode

interface HtmlColorUtilsProtocol {
    fun choose(mode: ChordsViewMode): HtmlColors
}
