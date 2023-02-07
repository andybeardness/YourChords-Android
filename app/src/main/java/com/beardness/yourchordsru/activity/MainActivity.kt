package com.beardness.yourchordsru.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.beardness.yourchordsru.activity.scaffold.AdBottomBarScaffold
import com.beardness.yourchordsru.ui.theme.YourChordsRuTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        compose()
    }

    private fun compose() {
        setContent {
            YourChordsRuTheme {
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
}