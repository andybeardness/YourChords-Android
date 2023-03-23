package com.beardness.yourchordsru.presentation.screens.author

import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.navigation.navigator.INavigator
import com.beardness.yourchordsru.presentation.core.authors.IAuthorsCore
import com.beardness.yourchordsru.presentation.core.favorite.IFavoriteCore
import com.beardness.yourchordsru.presentation.core.settings.ISettingsCore
import com.beardness.yourchordsru.presentation.core.songs.ISongsCore
import com.beardness.yourchordsru.presentation.screens.dto.SongViewDto
import com.beardness.yourchordsru.presentation.screens.dto.songsCoreDtoToViewDto
import com.beardness.yourchordsru.presentation.screens.dto.viewDto
import com.beardness.yourchordsru.utils.sorttype.SongsSortType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorScreenViewModel @Inject constructor(
    private val authorsCore: IAuthorsCore,
    private val songsCore: ISongsCore,
    private val settingsCore: ISettingsCore,
    private val favoriteCore: IFavoriteCore,
    private val navigator: INavigator,
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope,
): ViewModel(), IAuthorScreenViewModel {

    private val _authorName = MutableStateFlow<String>(value = "")
    override val authorName = _authorName.asStateFlow()

    private val _authorId = MutableStateFlow<Int>(value = -1)

    private val _isFavorite = MutableStateFlow<Boolean>(value = false)
    override val isFavorite = _isFavorite.asStateFlow()

    private val _songs = MutableStateFlow<List<SongViewDto>>(value = emptyList())
    override val songs = _songs.asStateFlow()

    private val _songsSortType = MutableStateFlow<SongsSortType>(value = SongsSortType.BY_NAME)
    override val songsSortType = _songsSortType.asStateFlow()

    override val favoriteSongsIds: Flow<List<Int>> =
        favoriteCore
            .favoriteSongs
            .map { songs ->
                songs.map { song -> song.songId }
            }

    private var _lastScrollPosition: Int = 0
    private val _scrollUp = MutableStateFlow<Boolean?>(value = null)
    override val scrollUp = _scrollUp.asStateFlow()

    init {
        collectSongSortType()
    }

    override fun load(authorId: Int?) {
        authorId ?: return

        ioCoroutineScope.launch {
            _authorId.emit(value = authorId)

            val authorName =
                authorsCore
                    .author(authorId = authorId)
                    ?.viewDto()
                    ?.name
                    ?: ""

            _authorName.emit(value = authorName)

            val favoriteAuthorsIds =
                favoriteCore
                    .favoriteAuthors
                    .value
                    .map { author -> author.authorId }

            val isAuthorFavorite =
                favoriteAuthorsIds
                    .contains(element = authorId)

            _isFavorite.emit(value = isAuthorFavorite)

            val songs =
                songsCore
                    .songs(authorId = authorId)
                    .songsCoreDtoToViewDto()
                    .sort(type = _songsSortType.value)

            _songs.emit(value = songs)
        }
    }

    override fun navigateToSong(authorId: Int, songId: Int) {
        navigator.song(authorId = authorId, songId = songId)
    }

    override fun navigateToSearch() {
        navigator.search()
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

    override fun switchSortType() {
        ioCoroutineScope.launch {
            val newSongsSortType =
                when (_songsSortType.value) {
                    SongsSortType.BY_NAME -> SongsSortType.BY_RATING
                    SongsSortType.BY_RATING -> SongsSortType.BY_NAME
                }

            settingsCore.setupSongsSortType(songsSortType = newSongsSortType)
        }
    }

    private fun collectSongSortType() {
        ioCoroutineScope.launch {
            settingsCore.songsSortType.collect { songsSortType ->
                _songsSortType.emit(value = songsSortType)

                val sortedSongs =
                    _songs.value
                        .sort(type = _songsSortType.value)

                _songs.emit(value = sortedSongs)
            }
        }
    }

    private fun List<SongViewDto>.sort(type: SongsSortType): List<SongViewDto> =
        when (type) {
            SongsSortType.BY_NAME -> {
                this.sortedWith(
                    compareBy(
                        { songViewDto -> songViewDto.title },
                        { songViewDto -> -songViewDto.rating },
                    )
                )
            }
            SongsSortType.BY_RATING -> {
                this.sortedWith(
                    compareBy(
                        { songViewDto -> -songViewDto.rating },
                        { songViewDto -> songViewDto.title },
                    )
                )
            }
        }

    override fun changeAuthorFavorite() {
        ioCoroutineScope.launch {
            val authorId = _authorId.value

            favoriteCore.changeAuthorFavorite(authorId = authorId)

            _isFavorite.emit(value = !_isFavorite.value)
        }
    }

    override fun changeSongFavorite(songId: Int) {
        ioCoroutineScope.launch {
            val authorId = _authorId.value

            favoriteCore.changeSongFavorite(authorId = authorId, songId = songId)
        }
    }
}