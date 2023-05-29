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
import com.beardness.yourchordsru.presentation.view.compose.component.AvatarComponent
import com.beardness.yourchordsru.presentation.view.compose.component.ButtonComponent
import com.beardness.yourchordsru.presentation.view.compose.component.DescriptionComponent
import com.beardness.yourchordsru.presentation.view.compose.component.IconComponent
import com.beardness.yourchordsru.presentation.view.types.FavoriteViewType
import com.beardness.yourchordsru.theme.YourChordsRuTheme

@Composable
fun AuthorWidget(
    name: String,
    songsCount: Int,
    onClick: () -> Unit,
    favoriteType: FavoriteViewType,
    onClickFavorite: () -> Unit,
) {
    val favoriteButtonIcon = when (favoriteType) {
        FavoriteViewType.DEFAULT -> Icons.Rounded.StarBorder
        FavoriteViewType.FAVORITE -> Icons.Rounded.Star
        FavoriteViewType.PARTLY -> Icons.Rounded.StarBorder
    }

    val favoriteButtonTint = when (favoriteType) {
        FavoriteViewType.DEFAULT -> YourChordsRuTheme.colors.text
        FavoriteViewType.FAVORITE -> YourChordsRuTheme.colors.yellow
        FavoriteViewType.PARTLY -> YourChordsRuTheme.colors.yellow
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
                descriptions = listOf(
                    songsCount.toString(),
                ),
            )

            IconComponent(
                imageVector = Icons.Rounded.ArrowForwardIos,
                tint = Color.White.copy(alpha = .05f),
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
        songsCount = 1488,
        onClick = {},
        favoriteType = FavoriteViewType.DEFAULT,
        onClickFavorite = {},
    )
}

@Composable
@Preview
fun Preview_AuthorWidget_Favorite() {
    AuthorWidget(
        name = "King & Joker",
        songsCount = 1488,
        onClick = {},
        favoriteType = FavoriteViewType.FAVORITE,
        onClickFavorite = {},
    )
}

@Composable
@Preview
fun Preview_AuthorWidget_FavoritePartly() {
    AuthorWidget(
        name = "King & Joker",
        songsCount = 1488,
        onClick = {},
        favoriteType = FavoriteViewType.PARTLY,
        onClickFavorite = {},
    )
}