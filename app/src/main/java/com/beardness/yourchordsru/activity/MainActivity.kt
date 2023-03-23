package com.beardness.yourchordsru.activity

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.beardness.yourchordsru.activity.scaffold.AdBottomBarScaffold
import com.beardness.yourchordsru.presentation.screens.settings.types.ThemeSettingsType
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        compose()
        setup()
        collect()
    }

    private fun compose() {
        setContent {
            val theme by viewModel
                .theme
                .collectAsState(initial = ThemeSettingsType.DEVICE)

            YourChordsRuTheme(
                theme = theme,
            ) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = YourChordsRuTheme.colors.background
                ) {
                    AdBottomBarScaffold(
                        setupNavController = { navHostController ->
                            viewModel.setupNavController(
                                navHostController = navHostController,
                            )
                        }
                    )
                }
            }
        }
    }

    private fun setup() {
        setupFavorites()
    }

    private fun setupFavorites() {
        viewModel.setupFavorites()
    }

    private fun collect() {
        collectKeepScreenAwake()
    }

    private fun collectKeepScreenAwake() {
        lifecycleScope.launch {
            viewModel.keepScreenAwake.collect { isScreenNeedKeepAwake ->
                if (isScreenNeedKeepAwake) {
                    makeScreenAlwaysDisplay()
                } else {
                    unmakeScreenAlwaysDisplay()
                }
            }
        }
    }

    private fun makeScreenAlwaysDisplay() {
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }

    private fun unmakeScreenAlwaysDisplay() {
        window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }
}