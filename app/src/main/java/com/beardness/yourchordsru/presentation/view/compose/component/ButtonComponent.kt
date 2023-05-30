package com.beardness.yourchordsru.presentation.view.compose.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import com.beardness.yourchordsru.theme.YourChordsRuTheme

@Composable
fun ButtonComponent(
    imageVector: ImageVector,
    tint: Color,
    onClick: (() -> Unit)?,
) {
    Box(
        modifier = Modifier
            .size(size = YourChordsRuTheme.dimens.dp64)
            .padding(all = YourChordsRuTheme.dimens.dp8)
            .clip(shape = RoundedCornerShape(percent = 50))
            .clickable(
                enabled = onClick != null,
                onClick = { onClick?.invoke() },
                role = Role.Image
            )
            .padding(all = YourChordsRuTheme.dimens.dp8)
    ) {
        Icon(
            modifier = Modifier
                .size(size = YourChordsRuTheme.dimens.dp32),
            imageVector = imageVector,
            contentDescription = null,
            tint = tint,
        )
    }
}

@Composable
@Preview(name = "Favorite", group = "Favorite")
fun Preview_ButtonComponent_Favorite() {
    ButtonComponent(
        imageVector = Icons.Rounded.Star,
        tint = Color.Yellow,
        onClick = null,
    )
}

@Composable
@Preview(name = "FavoriteDefault", group = "Favorite")
fun Preview_ButtonComponent_FavoriteDefault() {
    ButtonComponent(
        imageVector = Icons.Rounded.StarBorder,
        tint = Color.White.copy(alpha = .2f),
        onClick = null,
    )
}

@Composable
@Preview(name = "FavoritePartly", group = "Favorite")
fun Preview_ButtonComponent_FavoritePartly() {
    ButtonComponent(
        imageVector = Icons.Rounded.StarBorder,
        tint = Color.Yellow,
        onClick = null,
    )
}

@Composable
@Preview(name = "ArrowForward", group = "Arrow")
fun Preview_ButtonComponent_ArrowForward() {
    ButtonComponent(
        imageVector = Icons.Rounded.ArrowForwardIos,
        tint = Color.White,
        onClick = null,
    )
}

@Composable
@Preview(name = "ArrowBack", group = "Arrow")
fun Preview_ButtonComponent_ArrowBack() {
    ButtonComponent(
        imageVector = Icons.Rounded.ArrowBackIos,
        tint = Color.White,
        onClick = null,
    )
}

@Composable
@Preview(name = "Search", group = "Action")
fun Preview_ButtonComponent_Search() {
    ButtonComponent(
        imageVector = Icons.Rounded.Search,
        tint = Color.White,
        onClick = null,
    )
}

@Composable
@Preview(name = "Settings", group = "Action")
fun Preview_ButtonComponent_Settings() {
    ButtonComponent(
        imageVector = Icons.Rounded.Tune,
        tint = Color.White,
        onClick = null,
    )
}

@Composable
@Preview(name = "TextIncrease", group = "Tune")
fun Preview_ButtonComponent_TextIncrease() {
    ButtonComponent(
        imageVector = Icons.Rounded.TextIncrease,
        tint = Color.White,
        onClick = null,
    )
}

@Composable
@Preview(name = "TextDecrease", group = "Tune")
fun Preview_ButtonComponent_TextDecrease() {
    ButtonComponent(
        imageVector = Icons.Rounded.TextDecrease,
        tint = Color.White,
        onClick = null,
    )
}

@Composable
@Preview(name = "ThemeLight", group = "Tune")
fun Preview_ButtonComponent_ThemeLight() {
    ButtonComponent(
        imageVector = Icons.Rounded.LightMode,
        tint = Color.White,
        onClick = null,
    )
}

@Composable
@Preview(name = "ThemeDark", group = "Tune")
fun Preview_ButtonComponent_ThemeDark() {
    ButtonComponent(
        imageVector = Icons.Rounded.LightMode,
        tint = Color.White.copy(alpha = .2f),
        onClick = null,
    )
}