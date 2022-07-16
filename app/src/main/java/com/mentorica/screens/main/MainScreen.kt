package com.mentorica.screens.main

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.mentorica.nav.BottomNavItem
import com.mentorica.nav.BottomNavigationComponent
import com.mentorica.nav.NavRoute
import com.mentorica.nav.Navigator
import kotlinx.coroutines.flow.SharedFlow

@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {
    val bottomNavItems = listOf(BottomNavItem.HomeScreen, BottomNavItem.FavoritesScreen)
    Main(bottomNavItems, viewModel.navigator)
}

@Composable
fun Main(
    bottomNavItems: List<BottomNavItem>,
    navigator: Navigator
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(bottomNavItems, navigator::navigateTo) }
    ) {
        BottomNavigationComponent(navigator, navController)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val bottomNavItems = listOf(BottomNavItem.HomeScreen, BottomNavItem.FavoritesScreen)
    Main(bottomNavItems, object : Navigator{
        override val events: SharedFlow<NavRoute>
            get() = TODO("Not yet implemented")

        override fun navigateTo(navRoute: NavRoute) {
            TODO("Not yet implemented")
        }
    })
}

