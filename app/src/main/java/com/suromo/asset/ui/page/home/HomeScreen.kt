package com.suromo.asset.ui.page.home

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.suromo.asset.ui.theme.AssetTheme
import com.suromo.asset.ui.theme.BottomNavBarHeight
import com.suromo.asset.ui.theme.H7
import com.suromo.asset.ui.widget.AppToolBar

/**
 * author : Samuel
 * e-mail : xingtai.wei@icloud.com
 * time   : 2022/06/2022/6/3
 * desc   :
 */
@Composable
fun HomeScreen(
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
        AppToolBar(title = "明细")
        HomeBalanceBar()

        HomeBalanceList()

    }
}

@Preview
@Composable
fun PreviewHomeScreen(){
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    HomeScreen(navController,scaffoldState)
}