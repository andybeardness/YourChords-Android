package com.beardness.yourchordsru.presentation.core.search

import com.beardness.yourchordsru.presentation.core.dto.authorsRepoDtoToCoreDto
import com.beardness.yourchordsru.presentation.core.dto.songsRepoDtoToCoreDto
import com.beardness.yourchordsru.presentation.data.repo.authors.IAuthorsRepo
import com.beardness.yourchordsru.presentation.data.repo.favorite.IFavoriteRepo
import com.beardness.yourchordsru.presentation.data.repo.songs.ISongsRepo
import com.beardness.yourchordsru.presentation.screens.dto.search.SearchResult
import com.beardness.yourchordsru.presentation.screens.dto.search.SearchResultAuthor
import com.beardness.yourchordsru.presentation.screens.dto.search.SearchResultSong
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class SearchCore @Inject constructor(
    private val authorsRepo: IAuthorsRepo,
    private val songsRepo: ISongsRepo,
    private val favoriteRepo: IFavoriteRepo,
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
            val favoriteAuthorsIds =
                favoriteRepo
                    .authors()
                    .map { favoriteAuthorRepoDto -> favoriteAuthorRepoDto.authorId }

            val foundedAuthors =
                authors
                    .filter { authorCoreDto ->
                        authorCoreDto
                            .name
                            .lowercase()
                            .contains(other = pattern)
                    }
                    .map { authorCoreDto ->
                        val isFavorite =
                            favoriteAuthorsIds
                                .contains(element = authorCoreDto.id)

                        SearchResultAuthor(
                            authorId = authorCoreDto.id,
                            authorName = authorCoreDto.name,
                            isFavorite = isFavorite,
                        )
                    }

            currentFounded.addAll(elements = foundedAuthors)
            _founded.emit(value = currentFounded)
        }

        if (isSongsEnabled) {
            authors.forEach { authorCoreDto ->
                val favoriteSongsIds =
                    favoriteRepo
                        .songs()
                        .map { favoriteSongRepoDto -> favoriteSongRepoDto.songId }

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
                        .map { songCoreDto ->
                            val isFavorite = favoriteSongsIds.contains(element = songCoreDto.id)

                            SearchResultSong(
                                authorId = songCoreDto.authorId,
                                authorName = songCoreDto.authorName,
                                songId = songCoreDto.id,
                                songTitle = songCoreDto.title,
                                songRating = songCoreDto.rating,
                                isFavorite = isFavorite,
                            )
                        }

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