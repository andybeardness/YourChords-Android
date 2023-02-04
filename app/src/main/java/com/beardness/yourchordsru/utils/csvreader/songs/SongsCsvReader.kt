package com.beardness.yourchordsru.utils.csvreader.songs

import android.content.Context
import com.beardness.yourchordsru.presentation.data.datasource.dto.SongSourceDto
import com.beardness.yourchordsru.utils.csvreader.CsvReaderBase
import javax.inject.Inject

class SongsCsvReader @Inject constructor(
    private val context: Context,
): CsvReaderBase(context = context), ISongsCsvReader {
    companion object {
        private const val DIR = "data_songs"
        private const val SEPARATOR = '♔'
    }

    override fun read(authorId: Int): List<SongSourceDto> {
        val path = "$DIR/$authorId.csv"

        val reader = reader(filename = path)

        // header
        reader.readLine()

        return reader
            .lineSequence()
            .filter { row -> row.isNotBlank() }
            .map { row ->
                val (aid, id, name, title, rating, chords) = row.split(
                    SEPARATOR,
                    ignoreCase = false,
                    limit = 6,
                )

                SongSourceDto(
                    id = id.trim().toInt(),
                    title = title.trim(),
                    chords = chords.trim(),
                    rating = rating.trim().toInt(),
                    authorId = aid.trim().toInt(),
                )
            }.toList()
    }

    override fun read(authorId: Int, songId: Int): SongSourceDto? {
        return read(authorId = authorId)
            .firstOrNull { song -> song.id == songId }
    }

    private operator fun <T> List<T>.component6(): T = get(5)
}