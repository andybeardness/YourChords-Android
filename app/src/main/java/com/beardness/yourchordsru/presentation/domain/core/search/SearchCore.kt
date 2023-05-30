package com.beardness.yourchordsru.presentation.domain.core.search

import com.beardness.yourchordsru.presentation.data.reader.csv.authors.AuthorsCsvReaderProtocol
import com.beardness.yourchordsru.presentation.data.reader.csv.songs.SongsCsvReaderProtocol
import com.beardness.yourchordsru.presentation.entity.Author
import com.beardness.yourchordsru.presentation.entity.Song
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class SearchCore @Inject constructor(
    private val authorsCsvReader: AuthorsCsvReaderProtocol,
    private val songsCsvReader: SongsCsvReaderProtocol,
) : SearchCoreProtocol {

    private val _foundedAuthors = MutableStateFlow<List<Author>>(value = emptyList())
    override val foundedAuthors = _foundedAuthors.asStateFlow()

    private val _foundedSongs = MutableStateFlow<List<Song>>(value = emptyList())
    override val foundedSongs = _foundedSongs.asStateFlow()

    private val _isSearching = MutableStateFlow<Boolean>(value = false)
    override val isSearching = _isSearching.asStateFlow()

    override suspend fun search(
        pattern: String,
        isAuthorsEnabled: Boolean,
        isSongsEnabled: Boolean,
    ) {
        val isAllDisabled =
            !isAuthorsEnabled && !isSongsEnabled

        if (isAllDisabled) {
            return
        }

        _isSearching.emit(value = true)

        if (isAuthorsEnabled) {
            val searchedAuthors = searchInAuthors(pattern = pattern)
            _foundedAuthors.emit(value = searchedAuthors)
        }

        if (isSongsEnabled) {
            val searchedSongs = searchInSongs(pattern = pattern)
            _foundedSongs.emit(value = searchedSongs)
        }

        _isSearching.emit(value = false)
    }

    override suspend fun clear() {
        _foundedAuthors.emit(value = emptyList())
        _foundedSongs.emit(value = emptyList())
    }

    private fun searchInAuthors(
        pattern: String,
    ): List<Author> =
        authorsCsvReader
            .read()
            .filter { author -> author.name.isMatchPattern(pattern = pattern) }

    private fun searchInSongs(
        pattern: String,
    ): List<Song> =
        authorsCsvReader
            .read()
            .flatMap { author ->
                songsCsvReader
                    .read(authorId = author.id)
                    .filter { songDataDto ->
                        songDataDto.title.isMatchPattern(pattern = pattern) ||
                        songDataDto.chords.isMatchPattern(pattern = pattern)
                    }
            }

    private fun String.isMatchPattern(pattern: String): Boolean =
        this.lowercase()
            .contains(other = pattern)
}