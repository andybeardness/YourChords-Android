package com.beardness.yourchordsru.helpers.viewmode

import javax.inject.Inject

class ViewModeHelper @Inject constructor(
) : ViewModeHelperProtocol {

    override fun viewModeCodeOrDefault(current: Int?, size: Int, default: Int): Int {
        current ?: return default
        if (current >= size) return  default
        return current
    }

    override fun newViewModeCode(current: Int?, size: Int, default: Int): Int {
        current ?: return default
        return if (current >= size - 1 || current < 0) default else current + 1
    }
}