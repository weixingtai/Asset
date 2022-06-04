package com.suromo.asset.ui.page.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

/**
 * author : Samuel
 * e-mail : xingtai.wei@icloud.com
 * time   : 2022/06/2022/6/3
 * desc   :
 */
@Composable
fun SplashScreen(onNextPage: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            , contentAlignment = Alignment.TopCenter
    ) {
        LaunchedEffect(Unit) {
            delay(500)
            onNextPage.invoke()
        }
        Text(
            text = "Wan Android",
            fontSize = 32.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(0.dp, 150.dp, 0.dp, 0.dp)
        )
    }
}

@Preview
@Composable
fun PreviewSplashScreen(){
    SplashScreen {

    }
}