package com.beardness.yourchordsru.helpers.fontsize

import javax.inject.Inject

class FontSizeHelper @Inject constructor(
) : FontSizeHelperProtocol {
    override fun fontSizeOrDefault(fontSize: Int?, max: Int, min: Int, default: Int): Int =
        bound(value = fontSize ?: default, max = max, min = min)

    override fun increase(fontSize: Int?, step: Int, max: Int, min: Int, default: Int): Int =
        bound(value = (fontSize ?: default) + step, max = max, min = min)

    override fun decrease(fontSize: Int?, step: Int, max: Int, min: Int, default: Int): Int =
        bound(value = (fontSize ?: default) - step, max = max, min = min)

    private fun bound(value: Int, max: Int, min: Int): Int =
        when {
            value > max -> max
            value < min -> min
            else -> value
        }
}