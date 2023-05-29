package com.beardness.yourchordsru.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.beardness.yourchordsru.navigation.Navigation
import com.beardness.yourchordsru.theme.YourChordsRuTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        compose()
    }

    private fun compose() {
        setContent {
            YourChordsRuTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = YourChordsRuTheme.colors.background
                ) {
                    Navigation()
                }
            }
        }
    }
}