package com.mentorica.nav

import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

const val BOTTOM_BAR_ROUTE = "bottomBar"

@Composable
fun BottomNavigationComponent(
    navigator: Navigator,
    navController: NavHostController,
) {
    NavigationListener(navigator, navController)
    NavHost(
        navController = navController,
        startDestination = NavTarget.HomeScreen.path,
        route = BOTTOM_BAR_ROUTE
    ) {
        composable(NavTarget.HomeScreen.path) {
        }

        composable(NavTarget.FavoritesScreen.path) {
        }
    }
}

