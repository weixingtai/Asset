package com.suromo.asset.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.suromo.asset.ui.common.BottomNavRoute
import com.suromo.asset.ui.theme.AssetTheme

/**
 * author : Samuel
 * e-mail : xingtai.wei@icloud.com
 * time   : 2022/06/2022/6/3
 * desc   :
 */
@Composable
fun BottomNavBar(navHostController: NavHostController) {
    val bottomNavList = listOf(
        BottomNavRoute.Home,
        BottomNavRoute.Asset,
        BottomNavRoute.Keep,
        BottomNavRoute.Bill,
        BottomNavRoute.User
    )
    BottomNavigation {
        val navBackStackEntry by navHostController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        bottomNavList.forEach { screen ->
            BottomNavigationItem(
                modifier = Modifier.background(AssetTheme.colors.mainColor),

                icon = {
                    if(screen.icon != null){
                        Icon(
                            imageVector = screen.icon!!,
                            contentDescription = null,
                        )
                    }
                },
                selectedContentColor = AssetTheme.colors.themeUi,
                unselectedContentColor = AssetTheme.colors.textSecondary,
                label = { Text(text = stringResource(screen.name)) },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    if (screen.icon != null){
                        println("BottomNavView当前路由 ===> ${currentDestination?.hierarchy?.toList()}")
                        println("当前路由栈 ===> ${navHostController.graph.nodes}")
                        if (currentDestination?.route != screen.route) {
                            navHostController.navigate(screen.route) {
                                popUpTo(navHostController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                })
        }
    }
}

@Preview
@Composable
fun PreviewBottomNavBar(){
    val navController = rememberNavController()
    BottomNavBar(navHostController = navController)
}