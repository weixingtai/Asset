package com.suromo.asset.ui.page.home

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * author : Samuel
 * e-mail : xingtai.wei@icloud.com
 * time   : 2022/06/2022/6/3
 * desc   :
 */
@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    var viewStates by mutableStateOf(HomeViewState())
        private set

    fun dispatch(action: HomeViewAction) {
        when (action) {
            is HomeViewAction.OnStart -> onStart()
            is HomeViewAction.Refresh -> refresh()
        }
    }

    private fun onStart() {
//        viewStates = viewStates.copy(isLogged = AppUserUtil.isLogged)
//        if (viewStates.isLogged && viewStates.isInit.not()) {
//            viewStates = viewStates.copy(isInit = true)
//            initData()
//        }
    }

    private fun initData() {
//        viewStates = viewStates.copy(pagingData = pager)
//        fetchUrls()
    }

    private fun refresh() {
//        fetchUrls()
    }

//    init {
//        viewStates = viewStates.copy(
//            titles = listOf(
//                TabTitle(101, "广场"),
//                TabTitle(102, "推荐"),
//                TabTitle(103, "问答")
//            )
//        )
//    }

}

data class HomeViewState(
    val isInit: Boolean = false,
    val isRefreshing: Boolean = false,
    val listState: LazyListState = LazyListState(),
)

sealed class HomeViewAction {
    object OnStart : HomeViewAction()
    object Refresh : HomeViewAction()
}