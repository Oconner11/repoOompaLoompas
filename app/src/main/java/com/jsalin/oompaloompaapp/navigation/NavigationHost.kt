package com.jsalin.oompaloompaapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jsalin.oompaloompaapp.ui.detail.DetailScreen
import com.jsalin.oompaloompaapp.ui.home.HomeScreen

@Composable
fun NavigationAppHost(navHostController: NavHostController) {
    NavHost(navController = navHostController , startDestination = "home") {
        composable(DestinationScreens.Home.route) {
            HomeScreen(navController = navHostController)
        }
        composable(DestinationScreens.Detail.route) {
            DetailScreen()
        }
    }
}