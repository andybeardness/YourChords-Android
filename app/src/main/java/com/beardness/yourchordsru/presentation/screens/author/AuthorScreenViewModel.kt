package com.beardness.yourchordsru.presentation.screens.author

import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.navigation.navigator.INavigator
import com.beardness.yourchordsru.presentation.core.authors.IAuthorsCore
import com.beardness.yourchordsru.presentation.core.songs.ISongsCore
import com.beardness.yourchordsru.presentation.screens.dto.SongViewDto
import com.beardness.yourchordsru.presentation.screens.dto.songsCoreDtoToViewDto
import com.beardness.yourchordsru.presentation.screens.dto.viewDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorScreenViewModel @Inject constructor(
    private val authorsCore: IAuthorsCore,
    private val songsCore: ISongsCore,
    private val navigator: INavigator,
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope,
): ViewModel(), IAuthorScreenViewModel {

    private val _authorName = MutableStateFlow<String>(value = "")
    override val authorName = _authorName.asStateFlow()

    private val _songs = MutableStateFlow<List<SongViewDto>>(value = emptyList())
    override val songs = _songs.asStateFlow()

    private var _lastScrollPosition: Int = 0
    private val _scrollUp = MutableStateFlow<Boolean?>(value = null)
    override val scrollUp = _scrollUp.asStateFlow()

    override fun load(authorId: Int?) {
        authorId ?: return

        ioCoroutineScope.launch {
            val authorName =
                authorsCore
                    .author(authorId = authorId)
                    ?.viewDto()
                    ?.name
                    ?: ""

            _authorName.emit(value = authorName)

            val songs =
                songsCore
                    .songs(authorId = authorId)
                    .songsCoreDtoToViewDto()

            _songs.emit(value = songs)
        }
    }

    override fun navigateToSong(authorId: Int, songId: Int) {
        navigator.song(authorId = authorId, songId = songId)
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