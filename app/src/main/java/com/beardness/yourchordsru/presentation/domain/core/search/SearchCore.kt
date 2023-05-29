package com.beardness.yourchordsru.presentation.domain.core.search

import com.beardness.yourchordsru.presentation.data.reader.csv.authors.AuthorsCsvReaderProtocol
import com.beardness.yourchordsru.presentation.data.reader.csv.songs.SongsCsvReaderProtocol
import com.beardness.yourchordsru.presentation.domain.core.type.AuthorSearchResultCoreDto
import com.beardness.yourchordsru.presentation.domain.core.type.SearchResultCoreType
import com.beardness.yourchordsru.presentation.domain.core.type.SongSearchResultCoreDto
import com.beardness.yourchordsru.presentation.domain.core.type.toSearchResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class SearchCore @Inject constructor(
    private val authorsCsvReader: AuthorsCsvReaderProtocol,
    private val songsCsvReader: SongsCsvReaderProtocol,
) : SearchCoreProtocol {

    private val _founded = MutableStateFlow<List<SearchResultCoreType>>(value = emptyList())
    override val founded = _founded.asStateFlow()

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

        val currentFounded = mutableListOf<SearchResultCoreType>()

        if (isAuthorsEnabled) {
            val searchedAuthors = searchInAuthors(pattern = pattern)
            currentFounded.addAll(elements = searchedAuthors)
            _founded.emit(value = currentFounded)
        }

        if (isSongsEnabled) {
            val searchedSongs = searchInSongs(pattern = pattern)
            currentFounded.addAll(elements = searchedSongs)
            _founded.emit(value = currentFounded)
        }

        _isSearching.emit(value = false)
    }

    override suspend fun clear() {
        _founded.emit(value = emptyList())
    }

    private fun searchInAuthors(
        pattern: String,
    ): List<AuthorSearchResultCoreDto> =
        authorsCsvReader
            .read()
            .filter { authorDataDto -> authorDataDto.name.isMatchPattern(pattern = pattern) }
            .map { authorDataDto -> authorDataDto.toSearchResult() }

    private fun searchInSongs(
        pattern: String,
    ): List<SongSearchResultCoreDto> =
        authorsCsvReader
            .read()
            .flatMap { authorDataDto ->
                songsCsvReader.read(authorId = authorDataDto.id)
                    .filter { songDataDto ->
                        songDataDto.title.isMatchPattern(pattern = pattern) ||
                        songDataDto.chords.isMatchPattern(pattern = pattern)
                    }
                    .map { songDataDto -> songDataDto.toSearchResult() }
            }

    private fun String.isMatchPattern(pattern: String): Boolean =
        this.lowercase()
            .contains(other = pattern)
}