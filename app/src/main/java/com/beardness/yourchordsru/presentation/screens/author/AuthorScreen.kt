package com.beardness.yourchordsru.presentation.screens.author

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.beardness.yourchordsru.ui.widgets.SongWidget

@Composable
fun AuthorScreen(
    viewModel: IAuthorScreenViewModel,
    navigateToSong: (authorId: Int, songId: Int) -> Unit,
) {
    val songs by viewModel.songs.collectAsState()

    LazyColumn {
        items(count = songs.size) { index ->
            val songViewDto = songs[index]

            SongWidget(
                songViewDto = songViewDto,
                onClick = navigateToSong,
            )
        }
    }
}