package com.beardness.yourchordsru.presentation.screens.search

import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.navigation.navigator.INavigator
import com.beardness.yourchordsru.presentation.core.search.ISearchCore
import com.beardness.yourchordsru.presentation.screens.dto.SongViewDto
import com.beardness.yourchordsru.presentation.screens.dto.songsCoreDtoToViewDto
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
): ViewModel(), ISearchScreenViewModel {

    private val _foundSongs = MutableStateFlow<List<SongViewDto>>(value = emptyList())
    override val foundSongs = _foundSongs.asStateFlow()

    override fun search(pattern: String) {
        ioCoroutineScope.launch {
            val currentFoundedSong =
                searchCore
                    .searchSongs(pattern = pattern)
                    .songsCoreDtoToViewDto()

            _foundSongs.emit(value = currentFoundedSong)
        }
    }

    override fun navigateToSong(authorId: Int, songId: Int) {
        navigator.song(authorId = authorId, songId = songId)
    }
}