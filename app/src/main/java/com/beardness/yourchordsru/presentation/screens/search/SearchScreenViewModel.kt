package com.beardness.yourchordsru.presentation.screens.search

import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.navigation.navigator.INavigator
import com.beardness.yourchordsru.presentation.core.search.ISearchCore
import com.beardness.yourchordsru.presentation.screens.dto.search.SearchResult
import com.beardness.yourchordsru.presentation.screens.dto.search.SearchResultAuthor
import com.beardness.yourchordsru.presentation.screens.dto.search.SearchResultSong
import com.beardness.yourchordsru.utils.common.invert
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val navigator: INavigator,
    private val searchCore: ISearchCore,
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope,
) : ViewModel(), ISearchScreenViewModel {

    private val _input = MutableStateFlow<String>(value = "")
    override val input = _input.asStateFlow()

    private val _isSearchByAuthorsSelected = MutableStateFlow<Boolean>(value = true)
    override val isSearchByAuthorsSelected = _isSearchByAuthorsSelected.asStateFlow()

    private val _isSearchBySongsSelected = MutableStateFlow<Boolean>(value = true)
    override val isSearchBySongsSelected = _isSearchBySongsSelected.asStateFlow()

    override val searchResult = searchCore.founded
    override val isSearch = searchCore.isSearching

    private var _lastScrollPosition: Int = 0
    private val _scrollUp = MutableStateFlow<Boolean?>(value = null)
    override val scrollUp = _scrollUp.asStateFlow()

    override fun updateInput(update: String) {
        ioCoroutineScope.launch {
            _input.emit(value = update)
        }
    }

    override fun clickOnSearchByAuthorsTag() {
        ioCoroutineScope.launch {
            val newValue =
                _isSearchByAuthorsSelected
                    .value
                    .invert()

            _isSearchByAuthorsSelected.emit(value = newValue)
        }
    }

    override fun clickOnSearchBySongsTag() {
        ioCoroutineScope.launch {
            val newValue =
                _isSearchBySongsSelected
                    .value
                    .invert()

            _isSearchBySongsSelected.emit(value = newValue)
        }
    }

    override fun search(pattern: String) {
        ioCoroutineScope.launch {
            val prettyPattern =
                pattern
                    .trim()
                    .lowercase()

            if (prettyPattern.isEmpty()) {
                return@launch
            }

            searchCore.search(
                pattern = prettyPattern,
                isAuthorsEnabled = _isSearchByAuthorsSelected.value,
                isSongsEnabled = _isSearchBySongsSelected.value,
            )
        }
    }

    override fun clear() {
        ioCoroutineScope.launch {
            _input.emit(value = "")
            searchCore.clear()
        }
    }

    override fun navigateBySearchResult(searchResult: SearchResult) {
        when (searchResult) {
            is SearchResultAuthor -> navigator.author(
                authorId = searchResult.authorId,
            )
            is SearchResultSong -> navigator.song(
                authorId = searchResult.authorId,
                songId = searchResult.songId,
            )
        }
    }

    override fun navigateBack() {
        navigator.back()
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
}