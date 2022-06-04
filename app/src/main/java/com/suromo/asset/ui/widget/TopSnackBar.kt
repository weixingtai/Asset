package com.suromo.asset.ui.widget

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.suromo.asset.ui.theme.AssetTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * author : Samuel
 * e-mail : xingtai.wei@icloud.com
 * time   : 2022/06/2022/6/3
 * desc   :
 */
const val SNACK_INFO = ""
const val SNACK_WARN = " "
const val SNACK_ERROR = "  "
const val SNACK_SUCCESS = "OK"

@Composable
fun TopSnackBar(data: SnackbarData) {
    Snackbar(
        snackbarData = data,
        backgroundColor = when (data.actionLabel) {
            SNACK_INFO -> AssetTheme.colors.themeUi
            SNACK_WARN -> AssetTheme.colors.warn
            SNACK_ERROR -> AssetTheme.colors.error
            SNACK_SUCCESS -> AssetTheme.colors.success
            else -> AssetTheme.colors.themeUi
        },
        actionColor = AssetTheme.colors.textPrimary,
        contentColor = AssetTheme.colors.textPrimary,
    )
}

fun popupSnackBar(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    label: String,
    message: String,
    onDismissCallback: () -> Unit = {}
) {
    scope.launch {
        scaffoldState.snackbarHostState.showSnackbar(actionLabel = label, message = message)
        onDismissCallback.invoke()
    }

}

@Preview
@Composable
fun PreviewTopSnackBar(){
    val scaffoldState = rememberScaffoldState()
    SnackbarHost(
        hostState = scaffoldState.snackbarHostState
    ) { data ->
        println("actionLabel = ${data.actionLabel}")
        TopSnackBar(data = data)
    }
}