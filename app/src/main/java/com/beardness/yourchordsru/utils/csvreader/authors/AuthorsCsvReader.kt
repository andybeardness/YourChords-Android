package com.beardness.yourchordsru.utils.csvreader.authors

import android.content.Context
import com.beardness.yourchordsru.presentation.data.datasource.dto.AuthorSourceDto
import com.beardness.yourchordsru.utils.csvreader.CsvReaderBase
import javax.inject.Inject

class AuthorsCsvReader @Inject constructor(
    private val context: Context,
): CsvReaderBase(context = context), IAuthorsCsvReader {

    companion object {
        private const val FILENAME = "__authors.csv"
        private const val SEPARATOR = ','
    }

    override fun read(): List<AuthorSourceDto> {
        val reader = reader(filename = FILENAME)

        // header line
        reader.readLine()

        return reader
            .lineSequence()
            .filter { row -> row.isNotBlank() }
            .map { row ->
                val (id, name) = row.split(
                    SEPARATOR,
                    ignoreCase = false,
                    limit = 2,
                )

                AuthorSourceDto(
                    id = id.trim().toInt(),
                    name = name.trim()
                )
            }.toList()
    }
}