package com.beardness.yourchordsru.presentation.screens.song

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.presentation.core.songs.ISongsCore
import com.beardness.yourchordsru.presentation.screens.dto.viewDto
import com.beardness.yourchordsru.utils.html.IHtmlBuilder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SongScreenViewModel @Inject constructor(
    private val songsCore: ISongsCore,
    private val htmlBuilder: IHtmlBuilder,
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope,
): ViewModel(), ISongScreenViewModel {

    private val _chords = MutableStateFlow<String>(value = "")
    override val chords = _chords.asStateFlow()

    override fun load(
        authorId: Int?,
        songId: Int?,
        backgroundColor: Color,
        textColor: Color,
    ) {
        authorId ?: return
        songId ?: return

        ioCoroutineScope.launch {
            val song =
                songsCore
                    .song(
                        authorId = authorId,
                        songId = songId,
                    )
                    ?.viewDto()
                    ?: return@launch

            val chords =
                song.chords

            val htmlChords = htmlBuilder.html(
                content = chords,
                backgroundColor = backgroundColor,
                textColor = textColor,
            )

            _chords.emit(value = htmlChords)
        }
    }
}