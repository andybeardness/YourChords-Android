package com.beardness.yourchordsru.presentation.screens.chords

import android.util.Log
import androidx.lifecycle.ViewModel
import com.beardness.yourchordsru.di.qualifiers.IoCoroutineScope
import com.beardness.yourchordsru.presentation.core.songs.ISongsCore
import com.beardness.yourchordsru.presentation.screens.dto.ChordViewDto
import com.beardness.yourchordsru.presentation.screens.dto.stringChordNamesToChordViewDto
import com.beardness.yourchordsru.presentation.screens.dto.viewDto
import com.beardness.yourchordsru.utils.chords.regex.chordsTextToDistinctChordsByRegex
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChordsScreenViewModel @Inject constructor(
    private val songCore: ISongsCore,
    @IoCoroutineScope private val ioCoroutineScope: CoroutineScope
) : ViewModel(), IChordsScreenViewModel {

    private val _chords = MutableStateFlow<List<ChordViewDto>>(value = emptyList())
    override val chords = _chords.asStateFlow()

    override fun load(authorId: Int?, songId: Int?) {
        authorId ?: return
        songId ?: return

        ioCoroutineScope.launch {
            val chordsText =
                songCore
                    .song(
                        authorId = authorId,
                        songId = songId
                    )
                    ?.viewDto()
                    ?.chords
                    ?: return@launch

            val chords =
                chordsText
                    .chordsTextToDistinctChordsByRegex()
                    .stringChordNamesToChordViewDto()

            _chords.emit(value = chords)
        }
    }
}