package com.beardness.yourchordsru.presentation.view.compose.widget

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.material.icons.rounded.PersonOutline
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarBorder
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.beardness.yourchordsru.presentation.types.FavoriteType
import com.beardness.yourchordsru.presentation.view.compose.component.AvatarComponent
import com.beardness.yourchordsru.presentation.view.compose.component.ButtonComponent
import com.beardness.yourchordsru.presentation.view.compose.component.DescriptionComponent
import com.beardness.yourchordsru.presentation.view.compose.component.MiniIconComponent
import com.beardness.yourchordsru.theme.AppTheme
import com.beardness.yourchordsru.utils.extensions.clickableHaptic
import com.beardness.yourchordsru.utils.extensions.randomColor

@Composable
fun AuthorWidget(
    name: String,
    descriptions: List<String>,
    onClick: () -> Unit,
    favoriteType: FavoriteType,
    onClickFavorite: () -> Unit,
) {
    val avatarColor = randomColor(
        input = name,
        colors = listOf(
            AppTheme.colors.blue,
            AppTheme.colors.coral,
        ),
        default = AppTheme.colors.blue,
    )

    val favoriteButtonIcon = when (favoriteType) {
        FavoriteType.DEFAULT -> Icons.Rounded.StarBorder
        FavoriteType.FAVORITE -> Icons.Rounded.Star
        FavoriteType.PARTLY -> Icons.Rounded.StarBorder
    }

    val favoriteButtonTint by animateColorAsState(
        targetValue = when (favoriteType) {
            FavoriteType.DEFAULT -> MaterialTheme.colorScheme.onBackground.copy(alpha = .3f)
            FavoriteType.FAVORITE -> AppTheme.colors.yellow
            FavoriteType.PARTLY -> AppTheme.colors.yellow
        },
        animationSpec = tween(durationMillis = 250),
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.background)
            .clickableHaptic(action = onClick),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = AppTheme.dimens.dp8),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ButtonComponent(
                imageVector = favoriteButtonIcon,
                tint = favoriteButtonTint,
                onClick = onClickFavorite,
            )

            AvatarComponent(
                imageVector = Icons.Rounded.PersonOutline,
                tint = AppTheme.colors.white,
                color = avatarColor,
            )

            DescriptionComponent(
                modifier = Modifier
                    .weight(weight = 1f),
                title = name,
                descriptions = descriptions,
            )

            MiniIconComponent(
                imageVector = Icons.Rounded.ArrowForwardIos,
                tint = MaterialTheme.colorScheme.onBackground,
            )
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = AppTheme.dimens.dp16)
                .height(height = AppTheme.dimens.dp1)
                .background(color = MaterialTheme.colorScheme.onBackground.copy(alpha = .1f)),
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