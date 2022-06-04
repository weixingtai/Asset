package com.suromo.asset.ui.page.bill

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.suromo.asset.ui.page.home.HomeBalanceBar
import com.suromo.asset.ui.page.home.HomeBalanceList
import com.suromo.asset.ui.page.home.HomeViewAction
import com.suromo.asset.ui.page.home.HomeViewModel
import com.suromo.asset.ui.theme.BottomNavBarHeight
import com.suromo.asset.ui.widget.AppToolBar

/**
 * author : Samuel
 * e-mail : xingtai.wei@icloud.com
 * time   : 2022/06/2022/6/3
 * desc   :
 */
@Composable
fun BillScreen(
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
        AppToolBar(title = "账单")
        HomeBalanceBar()

        HomeBalanceList()

    }
}