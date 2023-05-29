package com.beardness.yourchordsru.presentation.data.reader.csv

import android.content.Context
import java.io.BufferedReader

abstract class CsvReaderBase constructor(
    private val context: Context,
) {

    fun reader(filename: String): BufferedReader {
        return context.assets.open(filename).bufferedReader()
    }
}