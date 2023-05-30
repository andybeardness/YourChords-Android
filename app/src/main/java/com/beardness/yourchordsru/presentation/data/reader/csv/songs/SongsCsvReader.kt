package com.beardness.yourchordsru.presentation.data.reader.csv.songs

import android.content.Context
import com.beardness.yourchordsru.presentation.data.reader.csv.CsvReaderBase
import com.beardness.yourchordsru.presentation.entity.Song
import javax.inject.Inject

class SongsCsvReader @Inject constructor(
    private val context: Context,
) : CsvReaderBase(context = context), SongsCsvReaderProtocol {

    companion object {
        private const val DIR = "data_songs"
        private const val SEPARATOR = '♔'
    }

    override fun read(authorId: Int): List<Song> {
        val path = "$DIR/$authorId.csv"

        val reader = reader(filename = path)

        // header
        reader.readLine()

        return reader
            .lineSequence()
            .filter { row -> row.isNotBlank() }
            .map { row ->
                val (id, title, rating, chords) = row.split(
                    SEPARATOR,
                    ignoreCase = false,
                    limit = 4,
                )

                Song(
                    id = id.trim().toInt(),
                    title = title.trim(),
                    ratingCount = rating.trim().toInt(),
                    chords = chords.trim(),
                )
            }.toList()
    }

    override fun read(authorId: Int, songId: Int): Song? {
        return read(authorId = authorId)
            .firstOrNull { song -> song.id == songId }
    }
}