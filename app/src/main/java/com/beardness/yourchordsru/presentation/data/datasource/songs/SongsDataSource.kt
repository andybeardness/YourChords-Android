package com.beardness.yourchordsru.presentation.data.datasource.songs

import com.beardness.yourchordsru.utils.csvreader.songs.ISongsCsvReader
import javax.inject.Inject

class SongsDataSource @Inject constructor(
    private val songsCsvReader: ISongsCsvReader,
): ISongsDataSource {

}