package com.beardness.yourchordsru.presentation.screens.author

import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.navigation.navigator.INavigator
import com.beardness.yourchordsru.presentation.core.songs.ISongsCore
import com.beardness.yourchordsru.presentation.screens.dto.SongViewDto
import com.beardness.yourchordsru.presentation.screens.dto.songsCoreDtoToViewDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorScreenViewModel @Inject constructor(
    private val songsCore: ISongsCore,
    private val navigator: INavigator,
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope,
): ViewModel(), IAuthorScreenViewModel {

    private val _songs = MutableStateFlow<List<SongViewDto>>(value = emptyList())
    override val songs = _songs.asStateFlow()

    override fun load(authorId: Int?) {
        authorId ?: return

        ioCoroutineScope.launch {
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
}