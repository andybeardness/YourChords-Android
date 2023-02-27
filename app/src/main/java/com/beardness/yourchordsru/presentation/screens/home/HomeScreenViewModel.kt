package com.beardness.yourchordsru.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.navigation.navigator.INavigator
import com.beardness.yourchordsru.presentation.core.authors.IAuthorsCore
import com.beardness.yourchordsru.presentation.core.favorite.IFavoriteCore
import com.beardness.yourchordsru.presentation.core.settings.ISettingsCore
import com.beardness.yourchordsru.presentation.screens.dto.types.AuthorsSortType
import com.beardness.yourchordsru.presentation.screens.dto.types.toComparator
import com.beardness.yourchordsru.presentation.screens.dto.viewDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val authorsCore: IAuthorsCore,
    private val favoriteCore: IFavoriteCore,
    private val settingsCore: ISettingsCore,
    private val navigator: INavigator,
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope,
) : ViewModel(), IHomeScreenViewModel {

    private val _authorsSortType = MutableStateFlow<AuthorsSortType>(value = AuthorsSortType.DEFAULT)
    override val authorsSortType = _authorsSortType.asStateFlow()

    override val authors =
        combine(
            authorsCore.authors,
            settingsCore.authorsSortType,
            favoriteCore.favoriteAuthors,
        ) { authors,
            sortType,
            favoriteAuthors ->

            val favoritesAuthorsIds =
                favoriteAuthors
                    .map { author -> author.authorId }

            val comparator =
                sortType.toComparator()

            val sortedAuthors =
                authors
                    .map { authorCoreDto ->
                        val authorId = authorCoreDto.id
                        val isFavorite = favoritesAuthorsIds.contains(element = authorId)

                        authorCoreDto.viewDto(isFavorite = isFavorite)
                    }
                    .sortedWith(comparator = comparator)

            sortedAuthors
        }

    override val authorsFirstChars =
        authorsCore.authors.map { authors ->
            authors.map { author -> author.name }
                .mapNotNull { author -> author.firstOrNull() }
                .distinct()
        }

    private var _lastScrollPosition: Int = 0
    private val _scrollUp = MutableStateFlow<Boolean?>(value = null)
    override val scrollUp = _scrollUp.asStateFlow()

    init {
        collectAuthorsSortType()
    }

    override fun navigateToHome() {
        navigator.home()
    }

    override fun navigateToAuthor(authorId: Int) {
        navigator.author(authorId = authorId)
    }

    override fun navigateToSearch() {
        navigator.search()
    }

    override fun navigateToSettings() {
        navigator.settings()
    }

    override fun navigateToAbout() {
        navigator.about()
    }

    override fun updateScrollPosition(firstVisibleItemIndex: Int) {
        if (firstVisibleItemIndex == _lastScrollPosition) {
            return
        }

        val newScrollUpValue = firstVisibleItemIndex <= _lastScrollPosition

        ioCoroutineScope.launch {
            _scrollUp.emit(value = newScrollUpValue)
            _lastScrollPosition = firstVisibleItemIndex
        }
    }

    override fun changeAuthorsSortType() {
        ioCoroutineScope.launch {
            val newValue =
                when (_authorsSortType.value) {
                    AuthorsSortType.DEFAULT -> AuthorsSortType.FAVORITE_FIRST
                    AuthorsSortType.FAVORITE_FIRST -> AuthorsSortType.DEFAULT
                }

            settingsCore.setupAuthorsSortType(authorsSortType = newValue)
        }
    }

    override fun makeFavorite(authorId: Int) {
        ioCoroutineScope.launch {
            favoriteCore.insertAuthor(authorId = authorId)
        }
    }

    override fun removeFavorite(authorId: Int) {
        ioCoroutineScope.launch {
            favoriteCore.removeAuthor(authorId = authorId)
        }
    }

    override fun indexOfFirstAuthor(char: Char): Int =
        authorsCore
            .authors
            .value
            .indexOfFirst { author ->
                author.name
                    .startsWith(char = char)
            }

    private fun collectAuthorsSortType() {
        ioCoroutineScope.launch {
            settingsCore.authorsSortType.collect { sortType ->
                _authorsSortType.emit(value = sortType)
            }
        }
    }
}