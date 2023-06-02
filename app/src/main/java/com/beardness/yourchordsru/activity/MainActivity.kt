package com.beardness.yourchordsru.activity

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.beardness.yourchordsru.ad.compose.scaffold.AdScaffold
import com.beardness.yourchordsru.navigation.Navigation
import com.beardness.yourchordsru.presentation.domain.usecase.awake.AwakeState
import com.beardness.yourchordsru.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        compose()
        collect()
    }

    private fun compose() {
        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    AdScaffold { paddingValues ->
                        Navigation(paddingValues = paddingValues)
                    }
                }
            }
        }
    }

    private fun collect() {
        lifecycleScope.launch {
            viewModel.awake.collect { state ->
                val signal = when (state) {
                    AwakeState.DEFAULT -> false
                    AwakeState.AWAKE -> true
                }

                keepScreenAwake(value = signal)
            }
        }
    }

    private fun keepScreenAwake(value: Boolean) {
        if (value) {
            window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        } else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        }
    }
}