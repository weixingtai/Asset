package com.suromo.asset.ui.page.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.suromo.asset.ui.theme.AssetTheme
import com.suromo.asset.ui.theme.H5
import com.suromo.asset.ui.theme.H7

/**
 * author : Samuel
 * e-mail : xingtai.wei@icloud.com
 * time   : 2022/06/2022/6/3
 * desc   :
 */
@Composable
fun HomeBalanceCard(){

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .padding(start = 20.dp, end = 20.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            val imageModifier = Modifier
                .heightIn(min = 20.dp)
                .clip(shape = MaterialTheme.shapes.medium)

            Icon(
                imageVector = Icons.Filled.Face,
                contentDescription = null,
                modifier = imageModifier,
                tint = AssetTheme.colors.themeUi

            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "美食",
                color = AssetTheme.colors.textPrimary,
                fontSize = H5
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "午餐",
                color = AssetTheme.colors.textSecondary,
                fontSize = H7
            )
        }

        Text(
            text = "18",
            color = AssetTheme.colors.textPrimary,
            fontSize = H5
        )
    }


}

@Preview
@Composable
fun PreviewHomeBalanceCard(){
    HomeBalanceCard()
}