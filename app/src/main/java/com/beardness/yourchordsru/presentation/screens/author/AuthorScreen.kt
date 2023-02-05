package com.beardness.yourchordsru.presentation.screens.author

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.beardness.yourchordsru.ui.widgets.song.SongWidget

@Composable
fun AuthorScreen(
    viewModel: IAuthorScreenViewModel,
) {
    val songs by viewModel.songs.collectAsState()

    LazyColumn {
        items(count = songs.size) { index ->
            val songViewDto = songs[index]

            val authorId = songViewDto.authorId
            val songId = songViewDto.id

            SongWidget(
                songViewDto = songViewDto,
                onClick = { viewModel.navigateToSong(authorId = authorId, songId = songId) },
            )
        }
    }
}