package com.beardness.yourchordsru.ui.widgets.settings.values

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.beardness.yourchordsru.config.ChordsConfig
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme

@Composable
fun SettingsValuePickerWidget(
    title: String,
    value: Int,
    minimum: Int,
    maximum: Int,
    onClickIncrease: () -> Unit,
    onClickDecrease: () -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(
                horizontal = YourChordsRuTheme.dimens.dp16,
                vertical = YourChordsRuTheme.dimens.dp8,
            ),
    ) {
        Text(
            modifier = Modifier
                .padding(
                    horizontal = YourChordsRuTheme.dimens.dp8,
                    vertical = YourChordsRuTheme.dimens.dp4,
                ),
            text = title,
            color = YourChordsRuTheme.colors.text,
            style = YourChordsRuTheme.typography.titleAtSettings,
        )

        SettingsValuesPickerLineWidget(
            value = value,
            isIncreaseButtonActive = value < maximum,
            isDecreaseButtonActive = value > minimum,
            onClickIncrease = { onClickIncrease() },
            onClickDecrease = { onClickDecrease() },
        )
    }
}

@Composable
@Preview
fun Preview_SettingsValuePickerWidget_0() {
    SettingsValuePickerWidget(
        title = "Font size",
        value = 18,
        minimum = ChordsConfig.MIN_FONT_SIZE_PX,
        maximum = ChordsConfig.MAX_FONT_SIZE_PX,
        onClickIncrease = { },
        onClickDecrease = { },
    )
}