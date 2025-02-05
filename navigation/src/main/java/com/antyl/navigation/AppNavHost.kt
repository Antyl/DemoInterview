package com.antyl.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.antyl.feature_something_list.presentation.SomethingListScreen

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
                onDetailsClick = { id ->
                    navHostController.navigate(Screen.SomethingDetails(id = id))
                }
            )
        }
    }
}