package com.beardness.yourchordsru.utils.csvreader

import android.content.Context
import java.io.BufferedReader

abstract class CsvReaderBase constructor(
    private val context: Context
) {

    fun reader(filename: String): BufferedReader {
        return context.assets.open(filename).bufferedReader()
    }
}