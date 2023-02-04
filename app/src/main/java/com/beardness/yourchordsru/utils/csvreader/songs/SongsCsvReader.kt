package com.beardness.yourchordsru.utils.csvreader.songs

import android.content.Context
import com.beardness.yourchordsru.presentation.data.datasource.dto.SongSourceDto
import com.beardness.yourchordsru.utils.csvreader.CsvReaderBase
import javax.inject.Inject

class SongsCsvReader @Inject constructor(
    private val context: Context,
): CsvReaderBase(context = context), ISongsCsvReader {
    companion object {
        private const val DIR = "__songs"
        private const val SEPARATOR = '♔'
    }

    override fun read(authorId: Int): List<SongSourceDto> {
        val path = "$DIR/$authorId.csv"

        val reader = reader(filename = path)
        val header = reader.readLine()

        return reader
            .lineSequence()
            .filter { row -> row.isNotBlank() }
            .map { row ->
                val (id, title, chords, rating, _authorId) = row.split(
                    SEPARATOR,
                    ignoreCase = false,
                    limit = 5,
                )

                SongSourceDto(
                    id = id.trim().toInt(),
                    title = title.trim(),
                    chords = chords.trim(),
                    rating = rating.trim().toInt(),
                    authorId = _authorId.trim().toInt(),
                )
            }.toList()
    }

    override fun read(authorId: Int, songId: Int): SongSourceDto? {
        return read(authorId = authorId)
            .firstOrNull { song -> song.id == songId }
    }
}