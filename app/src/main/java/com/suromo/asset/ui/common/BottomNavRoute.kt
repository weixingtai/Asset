package com.suromo.asset.ui.common

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.suromo.asset.R
import com.suromo.asset.ui.MainDestination

/**
 * author : Samuel
 * e-mail : xingtai.wei@icloud.com
 * time   : 2022/06/2022/6/3
 * desc   :
 */
sealed class BottomNavRoute(
    var route: String,
    @StringRes var name: Int,
    var icon: ImageVector? = null
) {
    object Home: BottomNavRoute(MainDestination.ROUTE_HOME, R.string.home, Icons.Default.Home)
    object Asset: BottomNavRoute(MainDestination.ROUTE_ASSET, R.string.asset, Icons.Default.Menu)
    object Keep: BottomNavRoute(MainDestination.ROUTE_KEEP, R.string.keep)
    object Bill: BottomNavRoute(MainDestination.ROUTE_BILL, R.string.bill, Icons.Default.Favorite)
    object User: BottomNavRoute(MainDestination.ROUTE_USER, R.string.mine, Icons.Default.Person)
}