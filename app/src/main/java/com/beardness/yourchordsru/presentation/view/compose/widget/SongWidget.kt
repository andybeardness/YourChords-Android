package com.beardness.yourchordsru.presentation.view.compose.widget

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarBorder
import androidx.compose.material.icons.rounded.Tag
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.beardness.yourchordsru.presentation.types.FavoriteType
import com.beardness.yourchordsru.presentation.view.compose.component.*
import com.beardness.yourchordsru.theme.AppTheme
import com.beardness.yourchordsru.utils.extensions.randomColor

@Composable
fun SongWidget(
    title: String,
    descriptions: List<String>,
    onClick: () -> Unit,
    favoriteType: FavoriteType,
    onClickFavorite: () -> Unit,
) {
    val songAvatarColor = randomColor(
        input = title,
        colors = listOf(
            AppTheme.colors.purple,
            AppTheme.colors.orange,
        ),
        default = AppTheme.colors.purple,
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
            .clickable(onClick = onClick),
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
                imageVector = Icons.Rounded.Tag,
                tint = AppTheme.colors.white,
                color = songAvatarColor,
            )

            DescriptionComponent(
                modifier = Modifier
                    .weight(weight = 1f),
                title = title,
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