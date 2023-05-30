package com.beardness.yourchordsru.presentation.data.reader.csv.authors

import android.content.Context
import com.beardness.yourchordsru.presentation.data.reader.csv.CsvReaderBase
import com.beardness.yourchordsru.presentation.entity.Author
import javax.inject.Inject

class AuthorsCsvReader @Inject constructor(
    private val context: Context,
) : CsvReaderBase(context = context), AuthorsCsvReaderProtocol {

    companion object {
        private const val FILENAME = "data_authors.csv"
        private const val SEPARATOR = ','
    }

    override fun read(): List<Author> {
        val reader = reader(filename = FILENAME)

        // header line
        reader.readLine()

        return reader
            .lineSequence()
            .filter { row -> row.isNotBlank() }
            .map { row ->
                val (id, name, songsCount, ratingCount) = row.split(
                    SEPARATOR,
                    ignoreCase = false,
                    limit = 4,
                )

                Author(
                    id = id.trim().toInt(),
                    name = name.trim(),
                    songsCount = songsCount.trim().toInt(),
                    ratingCount = ratingCount.trim().toInt(),
                )
            }.toList()
    }
}