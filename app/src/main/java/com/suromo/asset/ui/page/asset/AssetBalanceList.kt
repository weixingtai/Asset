package com.suromo.asset.ui.page.asset

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.suromo.asset.ui.theme.AssetTheme
import com.suromo.asset.ui.theme.H7

/**
 * author : Samuel
 * e-mail : xingtai.wei@icloud.com
 * time   : 2022/06/2022/6/3
 * desc   :
 */
@Composable
fun AssetBalanceList(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    state: LazyListState = rememberLazyListState(),
) {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(35.dp)
                .padding(start = 20.dp, end = 20.dp)
        ) {
            Text(
                text = "午餐",
                color = AssetTheme.colors.textSecondary,
                fontSize = H7
            )
            Text(
                text = "午餐",
                color = AssetTheme.colors.textSecondary,
                fontSize = H7
            )
        }
        LazyColumn(
            modifier = modifier,
            contentPadding = contentPadding,
            state = state
        ) {
            val postsFeed = listOf(1,2,3,4,5)
            item {
                Column {
                    postsFeed.forEach { post ->
                        AssetBalanceCard()
                        if (post != postsFeed[postsFeed.size-1]){
                            Divider(
                                modifier = Modifier.padding(start = 45.dp, end = 15.dp),
                                color = MaterialTheme.colors.onSurface.copy(alpha = 0.08f)
                            )
                        }

                    }
                }
            }
        }
        PostListDivider()
    }

}

/**
 * 分割线
 */
@Composable
private fun PostListDivider() {
    Divider(
        modifier = Modifier.padding(horizontal = 15.dp),
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.08f)
    )
}

@Preview
@Composable
fun PreviewHomeBalanceList(){
    AssetBalanceList()
}