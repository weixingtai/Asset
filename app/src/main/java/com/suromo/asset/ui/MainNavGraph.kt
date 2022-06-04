package com.suromo.asset.ui

import android.content.Context
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.suromo.asset.ui.MainDestination
import com.suromo.asset.ui.page.asset.AssetScreen
import com.suromo.asset.ui.page.bill.BillScreen
import com.suromo.asset.ui.page.home.HomeScreen
import com.suromo.asset.ui.page.keep.KeepScreen
import com.suromo.asset.ui.page.user.UserScreen

/**
 * author : Samuel
 * e-mail : xingtai.wei@icloud.com
 * time   : 2022/06/2022/6/4
 * desc   :
 */
@Composable
fun MainNavGraph(
    mContext: Context,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = MainDestination.ROUTE_HOME,
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        //首页
        composable(route = MainDestination.ROUTE_HOME) {
            HomeScreen(navController, scaffoldState)
        }
        //资产
        composable(route = MainDestination.ROUTE_ASSET) {
            AssetScreen(navController, scaffoldState)
        }
        //记账
        composable(route = MainDestination.ROUTE_KEEP) {
            KeepScreen(navController)
        }
        //账单
        composable(route = MainDestination.ROUTE_BILL) {
            BillScreen(navController, scaffoldState)
        }
        //我的
        composable(route = MainDestination.ROUTE_USER) {
            UserScreen(navController, scaffoldState)
        }
    }
}