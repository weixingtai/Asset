package com.suromo.asset

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.suromo.asset.ui.MainScreen
import com.suromo.asset.ui.page.splash.SplashScreen
import com.suromo.asset.ui.theme.AssetTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var isSplash by remember { mutableStateOf(true) }
                    if (isSplash) {
                        SplashScreen { isSplash = false }
                    } else {
                        MainScreen()
                    }
                }
            }
        }
    }
}
