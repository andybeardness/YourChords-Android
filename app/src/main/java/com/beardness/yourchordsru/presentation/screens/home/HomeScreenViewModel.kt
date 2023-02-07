package com.beardness.yourchordsru.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.navigation.navigator.INavigator
import com.beardness.yourchordsru.presentation.core.authors.IAuthorsCore
import com.beardness.yourchordsru.presentation.screens.dto.AuthorViewDto
import com.beardness.yourchordsru.presentation.screens.dto.authorsCoreDtoToViewDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val authorsCore: IAuthorsCore,
    private val navigator: INavigator,
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope,
) : ViewModel(), IHomeScreenViewModel {

    private val _authors = MutableStateFlow<List<AuthorViewDto>>(value = emptyList())
    override val authors = _authors.asStateFlow()

    private var _lastScrollPosition: Int = 0
    private val _scrollUp = MutableStateFlow<Boolean?>(value = null)
    override val scrollUp = _scrollUp.asStateFlow()

    init {
        load()
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

    private fun load() {
        ioCoroutineScope.launch {
            val currentAuthors =
                authorsCore
                    .authors()
                    .sortedBy { authorCoreDto -> authorCoreDto.name }
                    .authorsCoreDtoToViewDto()

            _authors.emit(value = currentAuthors)
        }
    }
}