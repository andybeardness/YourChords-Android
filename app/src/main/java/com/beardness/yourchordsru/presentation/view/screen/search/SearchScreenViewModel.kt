package com.beardness.yourchordsru.presentation.view.screen.search

import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.presentation.domain.usecase.authors.AuthorsUseCaseProtocol
import com.beardness.yourchordsru.presentation.domain.usecase.favorite.FavoriteUseCaseProtocol
import com.beardness.yourchordsru.presentation.domain.usecase.songs.SongsUseCaseProtocol
import com.beardness.yourchordsru.presentation.entity.Author
import com.beardness.yourchordsru.presentation.view.screen.search.types.Searched
import com.beardness.yourchordsru.presentation.view.screen.search.types.SearchedAuthor
import com.beardness.yourchordsru.presentation.view.screen.search.types.SearchedSong
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val authorsUseCase: AuthorsUseCaseProtocol,
    private val songsUseCase: SongsUseCaseProtocol,
    private val favoriteUseCase: FavoriteUseCaseProtocol,
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope,
) : ViewModel(), SearchScreenViewModelProtocol {

    companion object {
        private const val MIN_INPUT_SIZE = 4
    }

    private val _searchedAuthors = MutableStateFlow<List<SearchedAuthor>>(value = emptyList())
    private val _searchedSongs = MutableStateFlow<List<SearchedSong>>(value = emptyList())

    override val favoriteAuthorsIds = favoriteUseCase.favoriteAuthorsIds
    override val favoriteSongsIds = favoriteUseCase.favoriteSongsIds
    override val favoriteSongsAuthorsIds = favoriteUseCase.favoriteSongsAuthorsIds

    private val _input = MutableStateFlow(value = "")
    override val input = _input.asStateFlow()

    private val _loading = MutableStateFlow(value = false)
    override val loading = _loading.asStateFlow()

    override val searched =
        combine(
            _input,
            _searchedAuthors,
            _searchedSongs,
        ) { input,
            authors,
            songs ->

            if (input.isEmpty()) {
                return@combine null
            }

            val result = mutableListOf<Searched>()
            result.addAll(elements = authors)
            result.addAll(elements = songs)

            result
        }.filterNotNull()

    override fun updateInput(update: String) {
        ioCoroutineScope.launch {
            _input.emit(value = update)
        }
    }

    override fun search(input: String) {
        ioCoroutineScope.launch {
            val pattern = input
                .trim()
                .lowercase()

            if (pattern.length < MIN_INPUT_SIZE) {
                return@launch
            }

            loading {
                clearSearch()

                val authors = authorsUseCase.authors()

                searchInAuthors(authors = authors, pattern = pattern)
                searchInSongs(authors = authors, pattern = pattern)
            }
        }
    }

    override fun swapAuthorFavorite(authorId: Int) {
        ioCoroutineScope.launch {
            favoriteUseCase.changeAuthorFavorite(authorId = authorId)
        }
    }

    override fun swapSongFavorite(authorId: Int, songId: Int) {
        ioCoroutineScope.launch {
            favoriteUseCase.changeSongFavorite(authorId = authorId, songId = songId)
        }
    }

    private suspend fun clearSearch() {
        _searchedAuthors.emit(value = emptyList())
        _searchedSongs.emit(value = emptyList())
    }

    private suspend fun searchInAuthors(
        authors: List<Author>,
        pattern: String,
    ) {
        val searched =
            authors
                .filter { author ->
                    author.name
                        .lowercase()
                        .contains(other = pattern)
                }
                .map { author -> SearchedAuthor(author = author) }

        _searchedAuthors.emit(value = searched)
    }

    private suspend fun searchInSongs(
        authors: List<Author>,
        pattern: String,
    ) {
        val searched = mutableListOf<SearchedSong>()

        authors.forEach { author ->
            val searchedSongs =
                songsUseCase
                    .songs(authorId = author.id)
                    .filter { song ->
                        song.title
                            .lowercase()
                            .contains(other = pattern) ||
                        song.chords
                            .lowercase()
                            .contains(other = pattern)
                    }
                    .map { song ->
                        SearchedSong(
                            song = song,
                            authorId = author.id,
                            authorName = author.name,
                        )
                    }

            searched.addAll(elements = searchedSongs)
        }

        _searchedSongs.emit(value = searched)
    }

    private suspend fun loading(action: suspend () -> Unit) {
        _loading.emit(value = true)
        action()
        _loading.emit(value = false)
    }
}