package com.antyl.navigation

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.antyl.feature_something_details.presentation.SomethingDetailsScreen
import com.antyl.feature_something_details.presentation.SomethingDetailsViewModel
import com.antyl.feature_something_list.presentation.SomethingListScreen
import com.antyl.feature_something_list.presentation.SomethingListViewModel

@Composable
fun AppNavHost(
    navHostController: NavHostController = rememberNavController(),
    startDestination: Any = Screen.SomethingList,
    paddingValues: PaddingValues
) {

    NavHost(
        modifier = Modifier.padding(paddingValues),
        navController = navHostController,
        startDestination = startDestination
    ) {
        composable<Screen.SomethingList> {
            SomethingListScreen(
                viewModel = hiltViewModel(),
                onDetailsClick = { id ->
                    navHostController.navigate(Screen.SomethingDetails(id = id))
                }
            )
        }
        composable<Screen.SomethingDetails> { backStackEntry ->
            val s = backStackEntry.toRoute<Screen.SomethingDetails>()
            val param = remember(backStackEntry) {
                navHostController.getBackStackEntry<Screen.SomethingDetails>()
            }
            SideEffect {
                Log.e("TAG", param.toString())
            }
            SomethingDetailsScreen(
                viewModel = hiltViewModel<SomethingDetailsViewModel>(param),
            )
        }
    }
}