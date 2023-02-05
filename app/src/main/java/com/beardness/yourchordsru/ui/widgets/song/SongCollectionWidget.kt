package com.beardness.yourchordsru.ui.widgets.song

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.beardness.yourchordsru.presentation.screens.dto.SongViewDto

@Composable
fun SongCollectionWidget(
    modifier: Modifier,
    lazyListState: LazyListState,
    songs: List<SongViewDto>,
    onCLick: (authorId: Int, songId: Int) -> Unit,
) {
    LazyColumn(
        modifier = modifier,
        state = lazyListState,
    ) {
        items(count = songs.size) { index ->
            val songViewDto = songs[index]

            val authorId = songViewDto.authorId
            val songId = songViewDto.id

            SongWidget(
                songViewDto = songViewDto,
                onClick = { onCLick(authorId, songId) },
            )
        }
    }
}