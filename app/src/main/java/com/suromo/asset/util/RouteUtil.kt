package com.suromo.asset.util

import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

/**
 * author : Samuel
 * e-mail : xingtai.wei@icloud.com
 * time   : 2022/06/2022/6/3
 * desc   :
 */
object RouteUtils {

    const val STEAD_SYMBOL = "^0^"

    //初始化Bundle参数
    fun initBundle(params: Parcelable) = Bundle().apply { putParcelable(ARGS, params) }

    /**
     * 导航到某个页面
     */
    fun navTo(
        navController: NavController,
        destinationName: String,
        args: Any? = null,
        backStackRouteName: String? = null,
        isLaunchSingleTop: Boolean = true,
        needToRestoreState: Boolean = true,
    ) {

        var singleArgument = ""
        if (args != null) {
            when (args) {
                is Parcelable -> {
                    singleArgument = String.format("/%s", Uri.encode(args.toJson()))
                }
                is String -> {
                    singleArgument = String.format("/%s", args)
                }
                is Int -> {
                    singleArgument = String.format("/%s", args)
                }
                is Float -> {
                    singleArgument = String.format("/%s", args)
                }
                is Double -> {
                    singleArgument = String.format("/%s", args)
                }
                is Boolean -> {
                    singleArgument = String.format("/%s", args)
                }
                is Long -> {
                    singleArgument = String.format("/%s", args)
                }
            }
        }
        println("导航到： $destinationName")
        navController.navigate("$destinationName$singleArgument") {
            if (backStackRouteName != null) {
                popUpTo(backStackRouteName) { saveState = true }
            }
            launchSingleTop = isLaunchSingleTop
            restoreState = needToRestoreState
        }
    }

    fun NavHostController.back() {
        navigateUp()
    }

    private fun getPopUpId(navCtrl: NavHostController, routeName: String?): Int {
        val defaultId = navCtrl.graph.findStartDestination().id
        return if (routeName == null) {
            defaultId
        } else {
            navCtrl.findDestination(routeName)?.id ?: defaultId
        }
    }

    fun <T> getArguments(navCtrl: NavHostController): T? {
        return navCtrl.previousBackStackEntry?.arguments?.getParcelable(ARGS)
    }

    /**
     * 各个序列化的参数类的key名
     */
    private const val ARGS = "args"


}