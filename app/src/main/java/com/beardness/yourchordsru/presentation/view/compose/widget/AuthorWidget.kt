package com.beardness.yourchordsru.presentation.view.compose.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.material.icons.rounded.PersonOutline
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.beardness.yourchordsru.presentation.types.FavoriteType
import com.beardness.yourchordsru.presentation.view.compose.component.*
import com.beardness.yourchordsru.theme.YourChordsRuTheme

@Composable
fun AuthorWidget(
    name: String,
    descriptions: List<String>,
    onClick: () -> Unit,
    favoriteType: FavoriteType,
    onClickFavorite: () -> Unit,
) {
    val favoriteButtonIcon = when (favoriteType) {
        FavoriteType.DEFAULT -> Icons.Rounded.StarBorder
        FavoriteType.FAVORITE -> Icons.Rounded.Star
        FavoriteType.PARTLY -> Icons.Rounded.StarBorder
    }

    val favoriteButtonTint = when (favoriteType) {
        FavoriteType.DEFAULT -> YourChordsRuTheme.colors.text
        FavoriteType.FAVORITE -> YourChordsRuTheme.colors.yellow
        FavoriteType.PARTLY -> YourChordsRuTheme.colors.yellow
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = YourChordsRuTheme.dimens.dp8),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ButtonComponent(
                imageVector = favoriteButtonIcon,
                tint = favoriteButtonTint,
                onClick = onClickFavorite,
            )

            AvatarComponent(
                imageVector = Icons.Rounded.PersonOutline,
                tint = Color.White,
                color = Color.Blue,
            )

            DescriptionComponent(
                modifier = Modifier
                    .weight(weight = 1f),
                title = name,
                descriptions = descriptions,
            )

            MiniIconComponent(
                imageVector = Icons.Rounded.ArrowForwardIos,
                tint = Color.White,
            )
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = YourChordsRuTheme.dimens.dp1)
                .background(color = YourChordsRuTheme.colors.text.copy(alpha = .1f)),
        )
    }
}

@Composable
@Preview
fun Preview_AuthorWidget_FavoriteDefault() {
    AuthorWidget(
        name = "King & Joker",
        descriptions = listOf("Songs: 1488", "Rating: 20220"),
        onClick = {},
        favoriteType = FavoriteType.DEFAULT,
        onClickFavorite = {},
    )
}

@Composable
@Preview
fun Preview_AuthorWidget_Favorite() {
    AuthorWidget(
        name = "King & Joker",
        descriptions = listOf("Songs: 1488", "Rating: 20220"),
        onClick = {},
        favoriteType = FavoriteType.FAVORITE,
        onClickFavorite = {},
    )
}

@Composable
@Preview
fun Preview_AuthorWidget_FavoritePartly() {
    AuthorWidget(
        name = "King & Joker",
        descriptions = listOf("Songs: 1488", "Rating: 20220"),
        onClick = {},
        favoriteType = FavoriteType.PARTLY,
        onClickFavorite = {},
    )
}