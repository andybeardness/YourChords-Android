package com.beardness.yourchordsru.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.navigation.navigator.INavigator
import com.beardness.yourchordsru.presentation.core.authors.IAuthorsCore
import com.beardness.yourchordsru.presentation.core.favorite.IFavoriteCore
import com.beardness.yourchordsru.presentation.screens.dto.AuthorViewDto
import com.beardness.yourchordsru.presentation.screens.dto.types.AuthorsSortType
import com.beardness.yourchordsru.presentation.screens.dto.viewDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val authorsCore: IAuthorsCore,
    private val favoriteCore: IFavoriteCore,
    private val navigator: INavigator,
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope,
) : ViewModel(), IHomeScreenViewModel {

    private val _authorsSortType = MutableStateFlow<AuthorsSortType>(value = AuthorsSortType.DEFAULT)
    override val authorsSortType = _authorsSortType.asStateFlow()

    private val _authors = MutableStateFlow<List<AuthorViewDto>>(value = emptyList())
    override val authors = _authors.asStateFlow()

    override val authorsFirstChars =
        _authors.map { authors ->
            authors.map { author -> author.name }
                .mapNotNull { author -> author.firstOrNull() }
                .distinct()
        }

    private var _lastScrollPosition: Int = 0
    private val _scrollUp = MutableStateFlow<Boolean?>(value = null)
    override val scrollUp = _scrollUp.asStateFlow()

    init {
        load()
        collectFavoriteAuthors()
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

            _authorsSortType.emit(value = newValue)
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
        _authors.value.indexOfFirst { author -> author.name.startsWith(char = char) }

    private fun load() {
        ioCoroutineScope.launch {
            val favoritesAuthorsIds =
                favoriteCore
                    .favoriteAuthors
                    .value
                    .map { favoriteAuthorCoreDto -> favoriteAuthorCoreDto.authorId }

            val authorsView =
                authorsCore
                    .authors()
                    .sortedBy { authorCoreDto -> authorCoreDto.name }
                    .map { authorCoreDto ->
                        val isFavorite = favoritesAuthorsIds.contains(element = authorCoreDto.id)

                        authorCoreDto.viewDto(isFavorite = isFavorite)
                    }

            _authors.emit(value = authorsView)
        }
    }

    private fun collectFavoriteAuthors() {
        ioCoroutineScope.launch {
            favoriteCore.favoriteAuthors.collect { favoriteAuthors ->
                load()
            }
        }
    }
}