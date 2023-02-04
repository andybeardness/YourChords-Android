package com.beardness.yourchordsru.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.beardness.yourchordsru.presentation.screens.dto.SongViewDto
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

@Composable
fun SongWidget(
    songViewDto: SongViewDto,
    onClick: (authorId: Int, songId: Int) -> Unit,
) {
    val authorId = songViewDto.authorId
    val songId = songViewDto.id

    val shape = RoundedCornerShape(size = YourChordsRuTheme.dimens.dp8)

    val rating =
        songViewDto
            .rating
            .toString()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = YourChordsRuTheme.dimens.dp64)
            .background(color = YourChordsRuTheme.colors.background)
            .padding(all = YourChordsRuTheme.dimens.dp4)
            .clip(shape = shape)
            .clickable { onClick(authorId, songId) }
            .background(
                color = YourChordsRuTheme.colors.card,
                shape = shape,
            )
            .padding(
                horizontal = YourChordsRuTheme.dimens.dp16,
                vertical = YourChordsRuTheme.dimens.dp8,
            ),
    ) {
        Column(
            modifier = Modifier
                .weight(weight = 7f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                modifier = Modifier
                    .clickable { onClick(authorId, songId) },
                text = songViewDto.title,
                style = YourChordsRuTheme.typography.songNameAtSongCard,
                color = YourChordsRuTheme.colors.text,
                maxLines = 2,
            )
        }

        Column(
            modifier = Modifier
                .weight(weight = 1f)
                .fillMaxHeight()
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(weight = 1f),
                text = rating,
                style = YourChordsRuTheme.typography.ratingAtSongCard,
                color = YourChordsRuTheme.colors.text,
            )

            Icon(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(size = YourChordsRuTheme.dimens.dp16),
                imageVector = Icons.Rounded.Star,
                contentDescription = "",
                tint = YourChordsRuTheme.colors.yellow,
            )
        }
    }
}

@Composable
@Preview
fun Preview_SongWidget_0() {
    SongWidget(
        songViewDto = SongViewDto(
            id = 0,
            title = "Song title",
            chords = "Я помню наш последний вечер, наш последний разговор",
            rating = 999,
            authorId = 0,
        ),
        onClick = {_, _ -> }
    )
}

@Composable
@Preview
fun Preview_SongWidget_1() {
    SongWidget(
        songViewDto = SongViewDto(
            id = 0,
            title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat",
            chords = "Я помню наш последний вечер, наш последний разговор, по телу твоему скользит последний мой взор",
            rating = 999,
            authorId = 0,
        ),
        onClick = {_, _ -> }
    )
}