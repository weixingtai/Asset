package com.suromo.asset.ui

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

/**
 * author : Samuel
 * e-mail : xingtai.wei@icloud.com
 * time   : 2022/06/2022/6/3
 * desc   :
 */
object MainDestination {
    const val ROUTE_HOME = "home"
    const val ROUTE_ASSET = "asset"
    const val ROUTE_KEEP = "keep"
    const val ROUTE_BILL = "bill"
    const val ROUTE_USER = "user"

}


class MainNavigationAction(navController: NavHostController) {
    val navigateToHome: () -> Unit = {
        navController.navigate(MainDestination.ROUTE_HOME) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToAsset: () -> Unit = {
        navController.navigate(MainDestination.ROUTE_ASSET) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToKeep: () -> Unit = {
        navController.navigate(MainDestination.ROUTE_KEEP) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToBill: () -> Unit = {
        navController.navigate(MainDestination.ROUTE_BILL) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToUser: () -> Unit = {
        navController.navigate(MainDestination.ROUTE_USER) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}