package com.beardness.yourchordsru.ui.widgets.author

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.beardness.yourchordsru.presentation.screens.dto.AuthorViewDto
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme
import com.beardness.yourchordsru.utils.extensions.clickableHaptic
import com.beardness.yourchordsru.utils.extensions.clickableHapticNoRipple

@Composable
fun AuthorWidget(
    authorViewDto: AuthorViewDto,
    onClickAuthor: () -> Unit,
    actionChangeFavorite: () -> Unit,
) {
    val isFavorite = authorViewDto.isFavorite
    val shape = RoundedCornerShape(size = YourChordsRuTheme.dimens.dp8)

    val favoriteStar =
        if (isFavorite) {
            Icons.Rounded.Star
        } else {
            Icons.Rounded.StarBorder
        }

    val favoriteStarColor =
        if (isFavorite) {
            YourChordsRuTheme.colors.yellow
        } else {
            YourChordsRuTheme.colors.text.copy(alpha = .2f)
        }

    val favoriteStarColorAnimated by
        animateColorAsState(
            targetValue = favoriteStarColor,
            animationSpec = tween(
                durationMillis = 100,
                easing = LinearOutSlowInEasing,
            ),
        )

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
            .clickableHaptic { onClickAuthor() }
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
                .clickableHapticNoRipple { actionChangeFavorite() },
            imageVector = favoriteStar,
            tint = favoriteStarColorAnimated,
            contentDescription = "",
        )
        
        Spacer(
            modifier = Modifier
                .width(width = YourChordsRuTheme.dimens.dp8)
        )

        Text(
            modifier = Modifier
                .weight(weight = 1f),
            text = authorViewDto.name,
            style = YourChordsRuTheme.typography.authorNameAtAuthorCard,
            color = YourChordsRuTheme.colors.text,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Composable
@Preview
fun Preview_AuthorWidget_0() {
    AuthorWidget(
        authorViewDto = AuthorViewDto(
            id = 0,
            name = "Author name",
            isFavorite = false,
        ),
        onClickAuthor = {},
        actionChangeFavorite = {},
    )
}

@Composable
@Preview
fun Preview_AuthorWidget_1() {
    AuthorWidget(
        authorViewDto = AuthorViewDto(
            id = 0,
            name = "Long long long long long long long author name",
            isFavorite = true,
        ),
        onClickAuthor = {},
        actionChangeFavorite = {},
    )
}