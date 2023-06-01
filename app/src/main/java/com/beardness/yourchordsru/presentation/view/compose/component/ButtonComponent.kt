package com.beardness.yourchordsru.presentation.view.compose.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import com.beardness.yourchordsru.theme.AppTheme

@Composable
fun ButtonComponent(
    imageVector: ImageVector,
    tint: Color,
    onClick: (() -> Unit)?,
    rotation: Float = 0f,
) {
    Box(
        modifier = Modifier
            .size(size = AppTheme.dimens.dp64)
            .clip(shape = RoundedCornerShape(percent = 50))
            .clickable(
                enabled = onClick != null,
                onClick = { onClick?.invoke() },
                role = Role.Image
            )
            .padding(all = AppTheme.dimens.dp8),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            modifier = Modifier
                .size(size = AppTheme.dimens.dp32)
                .rotate(degrees = rotation),
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
        tint = AppTheme.colors.yellow,
        onClick = null,
    )
}

@Composable
@Preview(name = "FavoriteDefault", group = "Favorite")
fun Preview_ButtonComponent_FavoriteDefault() {
    ButtonComponent(
        imageVector = Icons.Rounded.StarBorder,
        tint = AppTheme.colors.white,
        onClick = null,
    )
}

@Composable
@Preview(name = "FavoritePartly", group = "Favorite")
fun Preview_ButtonComponent_FavoritePartly() {
    ButtonComponent(
        imageVector = Icons.Rounded.StarBorder,
        tint = AppTheme.colors.yellow,
        onClick = null,
    )
}

@Composable
@Preview(name = "ArrowForward", group = "Arrow")
fun Preview_ButtonComponent_ArrowForward() {
    ButtonComponent(
        imageVector = Icons.Rounded.ArrowForwardIos,
        tint = AppTheme.colors.white,
        onClick = null,
    )
}

@Composable
@Preview(name = "ArrowBack", group = "Arrow")
fun Preview_ButtonComponent_ArrowBack() {
    ButtonComponent(
        imageVector = Icons.Rounded.ArrowBackIos,
        tint = AppTheme.colors.white,
        onClick = null,
    )
}

@Composable
@Preview(name = "Search", group = "Action")
fun Preview_ButtonComponent_Search() {
    ButtonComponent(
        imageVector = Icons.Rounded.Search,
        tint = AppTheme.colors.white,
        onClick = null,
    )
}

@Composable
@Preview(name = "Settings", group = "Action")
fun Preview_ButtonComponent_Settings() {
    ButtonComponent(
        imageVector = Icons.Rounded.Tune,
        tint = AppTheme.colors.white,
        onClick = null,
    )
}

@Composable
@Preview(name = "TextIncrease", group = "Tune")
fun Preview_ButtonComponent_TextIncrease() {
    ButtonComponent(
        imageVector = Icons.Rounded.TextIncrease,
        tint = AppTheme.colors.white,
        onClick = null,
    )
}

@Composable
@Preview(name = "TextDecrease", group = "Tune")
fun Preview_ButtonComponent_TextDecrease() {
    ButtonComponent(
        imageVector = Icons.Rounded.TextDecrease,
        tint = AppTheme.colors.white,
        onClick = null,
    )
}

@Composable
@Preview(name = "ThemeLight", group = "Tune")
fun Preview_ButtonComponent_ThemeLight() {
    ButtonComponent(
        imageVector = Icons.Rounded.LightMode,
        tint = AppTheme.colors.white,
        onClick = null,
    )
}

@Composable
@Preview(name = "ThemeDark", group = "Tune")
fun Preview_ButtonComponent_ThemeDark() {
    ButtonComponent(
        imageVector = Icons.Rounded.LightMode,
        tint = AppTheme.colors.white,
        onClick = null,
    )
}