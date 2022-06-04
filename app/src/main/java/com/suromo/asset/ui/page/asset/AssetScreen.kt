package com.suromo.asset.ui.page.asset

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.suromo.asset.ui.page.home.*
import com.suromo.asset.ui.theme.BottomNavBarHeight
import com.suromo.asset.ui.widget.AppToolBar

/**
 * author : Samuel
 * e-mail : xingtai.wei@icloud.com
 * time   : 2022/06/2022/6/3
 * desc   :
 */
@Composable
fun AssetScreen(
    navHostController: NavHostController,
    scaffoldState: ScaffoldState,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val viewStates = viewModel.viewStates
    val isRefreshing = viewStates.isRefreshing

    DisposableEffect(Unit) {
        Log.i("debug", "onStart")
        viewModel.dispatch(HomeViewAction.OnStart)
        onDispose {
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = BottomNavBarHeight)
    ) {
        AppToolBar(title = "资产")
        AssetBalanceBar()
        AssetBalanceList()
    }
}

@Preview
@Composable
fun PreviewAssetScreen(){
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    AssetScreen(navController,scaffoldState)
}