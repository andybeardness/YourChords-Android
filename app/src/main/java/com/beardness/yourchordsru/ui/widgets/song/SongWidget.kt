package com.beardness.yourchordsru.ui.widgets.song

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.beardness.yourchordsru.presentation.screens.dto.SongViewDto
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme
import com.beardness.yourchordsru.utils.extensions.clickableHaptic
import com.beardness.yourchordsru.utils.extensions.clickableHapticNoRipple

@Composable
fun SongWidget(
    songViewDto: SongViewDto,
    onClick: () -> Unit,
    isFavorite: Boolean,
    onClickFavorite: () -> Unit,
    doesShowAuthor: Boolean = false,
) {
    val shape = RoundedCornerShape(size = YourChordsRuTheme.dimens.dp8)

    val rating =
        String.format(
            "%,d",
            songViewDto.rating,
        )

    val favoriteIcon =
        if (isFavorite) {
            Icons.Rounded.Star
        } else {
            Icons.Rounded.StarBorder
        }

    val favoriteColor =
        if (isFavorite) {
            YourChordsRuTheme.colors.yellow
        } else {
            YourChordsRuTheme.colors.text
        }

    val starShape = RoundedCornerShape(percent = 50)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = YourChordsRuTheme.dimens.dp64)
            .padding(
                top = YourChordsRuTheme.dimens.dp8,
                start = YourChordsRuTheme.dimens.dp4,
                end = YourChordsRuTheme.dimens.dp4,
            )
            .clip(shape = shape)
            .clickableHaptic { onClick() }
            .background(
                color = YourChordsRuTheme.colors.card,
                shape = shape,
            )
            .padding(
                horizontal = YourChordsRuTheme.dimens.dp8,
                vertical = YourChordsRuTheme.dimens.dp4,
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            modifier = Modifier
                .clip(shape = starShape)
                .clickableHapticNoRipple { onClickFavorite() },
            imageVector = favoriteIcon,
            tint = favoriteColor,
            contentDescription = "",
        )

        Spacer(
            modifier = Modifier
                .width(width = YourChordsRuTheme.dimens.dp8)
        )

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(weight = 1f),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = songViewDto.title,
                style = YourChordsRuTheme.typography.songTitleAtSongCard,
                color = YourChordsRuTheme.colors.text,
                maxLines = 2,
            )

            if (doesShowAuthor) {
                Text(
                    text = songViewDto.authorName,
                    style = YourChordsRuTheme.typography.songTitleAtSongCard,
                    color = YourChordsRuTheme.colors.text.copy(alpha = .2f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }

        Spacer(
            modifier = Modifier
                .width(width = YourChordsRuTheme.dimens.dp8)
        )

        Box(
            modifier = Modifier
                .fillMaxHeight(),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                modifier = Modifier,
                text = rating,
                style = YourChordsRuTheme.typography.ratingAtSongCard,
                color = YourChordsRuTheme.colors.text,
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
            rating = 999999,
            authorId = 0,
            authorName = "Author name",
        ),
        onClick = {},
        isFavorite = true,
        onClickFavorite = {},
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
            rating = 9999999,
            authorId = 0,
            authorName = "Author name",
        ),
        onClick = {},
        isFavorite = true,
        onClickFavorite = {},
    )
}