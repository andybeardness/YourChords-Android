package com.beardness.yourchordsru.helpers.fontsize

interface FontSizeHelperProtocol {
    fun fontSizeOrDefault(fontSize: Int?, max: Int, min: Int, default: Int): Int
    fun increase(fontSize: Int?, step: Int, max: Int, min: Int, default: Int): Int
    fun decrease(fontSize: Int?, step: Int, max: Int, min: Int, default: Int): Int
}