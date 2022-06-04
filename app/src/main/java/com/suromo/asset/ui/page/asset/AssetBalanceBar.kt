package com.suromo.asset.ui.page.asset

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orhanobut.logger.Logger
import com.suromo.asset.ui.theme.*

/**
 * author : Samuel
 * e-mail : xingtai.wei@icloud.com
 * time   : 2022/06/2022/6/3
 * desc   :
 */
@Composable
fun AssetBalanceBar() {
    Column(modifier = Modifier
        .wrapContentHeight()
        .background(AssetTheme.colors.themeUi)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(10.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "净资产",
                        color = AssetTheme.colors.mainColor,
                        fontSize = H7,
                        modifier = Modifier.padding(bottom = 1.dp, end = 5.dp)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(
                            text = "298" + ".",
                            color = AssetTheme.colors.mainColor,
                            fontSize = H2,
                            modifier = Modifier.padding(end = 2.dp)
                        )
                        Text(
                            text = "00",
                            color = AssetTheme.colors.mainColor,
                            fontSize = H4,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)) {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "资产",
                        color = AssetTheme.colors.mainColor,
                        fontSize = H7,
                        modifier = Modifier.padding(bottom = 1.dp, end = 5.dp)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(
                            text = "29338"+".",
                            color = AssetTheme.colors.mainColor,
                            fontSize = H3,
                            modifier = Modifier.padding(end = 2.dp)
                        )
                        Text(
                            text = "00",
                            color = AssetTheme.colors.mainColor,
                            fontSize = H6,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                    }

                }
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "负债",
                        color = AssetTheme.colors.mainColor,
                        fontSize = H7,
                        modifier = Modifier.padding(bottom = 1.dp, end = 5.dp)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(
                            text = "938" + ".",
                            color = AssetTheme.colors.mainColor,
                            fontSize = H3,
                            modifier = Modifier.padding(end = 2.dp)
                        )
                        Text(
                            text = "00",
                            color = AssetTheme.colors.mainColor,
                            fontSize = H6,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
        }
    }
}

@Preview
@Composable
fun PreviewHomeBalanceBar(){
    AssetBalanceBar()
}