package com.beardness.yourchordsru.helpers.viewmode

interface ViewModeHelperProtocol {
    fun viewModeCodeOrDefault(current: Int?, size: Int, default: Int): Int
    fun newViewModeCode(current: Int?, size: Int, default: Int): Int
}
