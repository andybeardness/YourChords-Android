package com.beardness.yourchordsru.presentation.view.screen.about

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIos
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.beardness.yourchordsru.R
import com.beardness.yourchordsru.presentation.view.compose.component.TextLineComponent
import com.beardness.yourchordsru.presentation.view.compose.widget.ToolbarWidget
import com.beardness.yourchordsru.presentation.view.entity.IconButton
import com.beardness.yourchordsru.theme.AppTheme

@Composable
fun AboutScreen(
    viewModel: AboutScreenViewModelProtocol,
    navigateBack: () -> Unit,
) {
    val title = stringResource(id = R.string.about)

    val texts = listOf(
        stringResource(id = R.string.about_main),
        stringResource(id = R.string.about_content),
        stringResource(id = R.string.about_user_data),
    )

    val privacy = stringResource(id = R.string.privacy_policy)

    val context = LocalContext.current

    val gotoPrivacyPolicy: () -> Unit = {
        val uri = Uri.parse("https://andybeardness.github.io/your-chords/")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        context.startActivity(intent)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ToolbarWidget(
            title = title,
            navigationButton = IconButton(
                imageVector = Icons.Rounded.ArrowBackIos,
                tint = MaterialTheme.colorScheme.onBackground,
                onClick = navigateBack,
            ),
            actionButton = emptyList(),
        )

        texts.forEach { text ->
            TextLineComponent(text = text)
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { gotoPrivacyPolicy() }
                .padding(
                    horizontal = AppTheme.dimens.dp16,
                    vertical = AppTheme.dimens.dp8,
                ),
            text = privacy,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
        )
    }
}