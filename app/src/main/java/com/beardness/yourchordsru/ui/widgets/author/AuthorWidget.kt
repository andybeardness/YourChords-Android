package com.beardness.yourchordsru.ui.widgets.author

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.beardness.yourchordsru.presentation.screens.dto.AuthorViewDto
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

@Composable
fun AuthorWidget(
    authorViewDto: AuthorViewDto,
    onClick: (authorId: Int) -> Unit,
) {
    val shape = RoundedCornerShape(size = YourChordsRuTheme.dimens.dp8)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = YourChordsRuTheme.dimens.dp64)
            .background(color = YourChordsRuTheme.colors.background)
            .padding(all = YourChordsRuTheme.dimens.dp4)
            .clip(shape = shape)
            .clickable { onClick(authorViewDto.id) }
            .background(
                color = YourChordsRuTheme.colors.card,
                shape = shape,
            )
            .padding(
                horizontal = YourChordsRuTheme.dimens.dp16,
                vertical = YourChordsRuTheme.dimens.dp8,
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier
                .weight(weight = 1f),
            text = authorViewDto.name,
            style = YourChordsRuTheme.typography.authorNameAtAuthorCard,
            color = YourChordsRuTheme.colors.text,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )

        Icon(
            imageVector = Icons.Rounded.Star,
            tint = YourChordsRuTheme.colors.yellow,
            contentDescription = "",
        )
    }
}

@Composable
@Preview
fun Preview_AuthorWidget_0() {
    AuthorWidget(
        authorViewDto = AuthorViewDto(
            id = 0,
            name = "Author name"
        ),
        onClick = {},
    )
}

@Composable
@Preview
fun Preview_AuthorWidget_1() {
    AuthorWidget(
        authorViewDto = AuthorViewDto(
            id = 0,
            name = "Long long long long long long long author name"
        ),
        onClick = {},
    )
}