package com.beardness.yourchordsru.presentation.core.search

import com.beardness.yourchordsru.presentation.core.dto.authorsRepoDtoToCoreDto
import com.beardness.yourchordsru.presentation.core.dto.songsRepoDtoToCoreDto
import com.beardness.yourchordsru.presentation.data.repo.authors.IAuthorsRepo
import com.beardness.yourchordsru.presentation.data.repo.songs.ISongsRepo
import com.beardness.yourchordsru.presentation.screens.dto.search.SearchResult
import com.beardness.yourchordsru.presentation.screens.dto.search.authorsCoreDtoToSearchResultAuthor
import com.beardness.yourchordsru.presentation.screens.dto.search.songsCoreDtoToSearchResultSong
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class SearchCore @Inject constructor(
    private val authorsRepo: IAuthorsRepo,
    private val songsRepo: ISongsRepo,
) : ISearchCore {

    private val _founded = MutableStateFlow<List<SearchResult>>(value = emptyList())
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

        val currentFounded = mutableListOf<SearchResult>()

        val authors =
            authorsRepo
                .authors()
                .authorsRepoDtoToCoreDto()

        if (isAuthorsEnabled) {
            val foundedAuthors =
                authors
                    .filter { authorCoreDto ->
                        authorCoreDto
                            .name
                            .lowercase()
                            .contains(other = pattern)
                    }
                    .authorsCoreDtoToSearchResultAuthor()

            currentFounded.addAll(elements = foundedAuthors)
            _founded.emit(value = currentFounded)
        }

        if (isSongsEnabled) {
            authors.forEach { authorCoreDto ->
                val foundedSongs =
                    songsRepo
                        .songs(authorId = authorCoreDto.id)
                        .songsRepoDtoToCoreDto()
                        .filter { songCoreDto ->
                            val isTitleMatch =
                                songCoreDto
                                    .title
                                    .lowercase()
                                    .contains(other = pattern)

                            val isChordsMath =
                                songCoreDto
                                    .chords
                                    .lowercase()
                                    .contains(other = pattern)

                            isTitleMatch || isChordsMath
                        }
                        .songsCoreDtoToSearchResultSong()

                if (foundedSongs.isNotEmpty()) {
                    currentFounded.addAll(elements = foundedSongs)
                    _founded.emit(value = currentFounded)
                }
            }
        }

        _isSearching.emit(value = false)
    }

    override suspend fun clear() {
        _founded.emit(value = emptyList())
    }
}