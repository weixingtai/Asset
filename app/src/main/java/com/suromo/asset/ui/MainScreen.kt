package com.suromo.asset.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.suromo.asset.MainApplication.Companion.mContext
import com.suromo.asset.ui.theme.AssetTheme
import com.suromo.asset.ui.widget.BottomNavBar
import com.suromo.asset.ui.widget.TopSnackBar
import com.suromo.asset.util.RouteUtils.navTo

/**
 * author : Samuel
 * e-mail : xingtai.wei@icloud.com
 * time   : 2022/06/2022/6/3
 * desc   :
 */
@Composable
fun MainScreen() {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                backgroundColor = AssetTheme.colors.themeUi,
                contentColor = AssetTheme.colors.mainColor,
                onClick = {
                navTo(navController = navController,
                    destinationName = MainDestination.ROUTE_KEEP,
                isLaunchSingleTop = true)
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "")
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            when (currentDestination?.route) {
                MainDestination.ROUTE_HOME -> BottomNavBar(navHostController = navController)
                MainDestination.ROUTE_ASSET -> BottomNavBar(navHostController = navController)
                MainDestination.ROUTE_BILL -> BottomNavBar(navHostController = navController)
                MainDestination.ROUTE_USER -> BottomNavBar(navHostController = navController)
            }
        },
        content = { innerPadding ->
            val contentModifier = Modifier.padding(innerPadding)

            MainNavGraph(mContext = mContext, modifier = contentModifier,navController = navController)

        },
        snackbarHost = {
            SnackbarHost(
                hostState = scaffoldState.snackbarHostState
            ) { data ->
                println("actionLabel = ${data.actionLabel}")
                TopSnackBar(data = data)
            }
        }
    )
}

@Preview
@Composable
fun PreviewMain(){
    MainScreen()
}