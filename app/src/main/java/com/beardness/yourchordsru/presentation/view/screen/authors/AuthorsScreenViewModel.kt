package com.beardness.yourchordsru.presentation.view.screen.authors

import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.presentation.domain.usecase.authors.AuthorsUseCaseProtocol
import com.beardness.yourchordsru.presentation.domain.usecase.favorite.FavoriteUseCaseProtocol
import com.beardness.yourchordsru.presentation.entity.Author
import com.beardness.yourchordsru.presentation.view.screen.authors.types.AuthorsSortType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorsScreenViewModel @Inject constructor(
    private val authorsUseCase: AuthorsUseCaseProtocol,
    private val favoriteUseCase: FavoriteUseCaseProtocol,
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope,
) : ViewModel(), AuthorsScreenViewModelProtocol {

    private val _sortType = MutableStateFlow(value = AuthorsSortType.DEFAULT)
    override val sortType = _sortType.asStateFlow()

    override val favoriteAuthorsIds =
        favoriteUseCase
            .favoriteAuthorsIds

    override val favoriteSongsAuthorsIds =
        favoriteUseCase
            .favoriteSongsAuthorsIds

    override val authors =
        combine(
            authorsUseCase.authors,
            favoriteAuthorsIds,
            favoriteSongsAuthorsIds,
            sortType
        ) { authors, favoriteAuthorsIds, favoriteSongsAuthorsIds, sort ->
            val comparator = when (sort) {
                AuthorsSortType.DEFAULT -> {
                    compareBy { author -> author.name }
                }
                AuthorsSortType.BY_FAVORITE -> {
                    compareByDescending<Author> { author -> author.id in favoriteAuthorsIds }
                        .thenByDescending { author -> author.id in favoriteSongsAuthorsIds }
                        .thenBy { author -> author.name }
                }
                AuthorsSortType.BY_RATING_COUNT -> {
                    compareByDescending<Author> { author -> author.ratingCount }
                        .thenBy { author -> author.name }
                }
                AuthorsSortType.BY_SONGS_COUNT -> {
                    compareByDescending<Author> { author -> author.songsCount }
                        .thenBy { author -> author.name }
                }
            }

            authors.sortedWith(comparator = comparator)
        }

    override fun swapAuthorFavorite(authorId: Int) {
        ioCoroutineScope.launch {
            favoriteUseCase.changeAuthorFavorite(authorId = authorId)
        }
    }

    override fun swapSortType() {
        ioCoroutineScope.launch {
            val nextSortType = when (_sortType.value) {
                AuthorsSortType.DEFAULT -> AuthorsSortType.BY_FAVORITE
                AuthorsSortType.BY_FAVORITE -> AuthorsSortType.BY_RATING_COUNT
                AuthorsSortType.BY_RATING_COUNT -> AuthorsSortType.BY_SONGS_COUNT
                AuthorsSortType.BY_SONGS_COUNT -> AuthorsSortType.DEFAULT
            }

            _sortType.emit(value = nextSortType)
        }
    }

    override fun resetSortType() {
        ioCoroutineScope.launch {
            _sortType.emit(value = AuthorsSortType.DEFAULT)
        }
    }
}