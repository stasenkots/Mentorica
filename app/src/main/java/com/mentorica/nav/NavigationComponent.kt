package com.mentorica.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mentorica.ui.get_started.GetStartedScreen
import com.mentorica.ui.splash.SplashScreen
import com.mentorica.utils.NAVIGATION
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach



@Composable
fun NavigationComponent(
    navigator: Navigator,
    navController: NavHostController,
) {
    NavigationListener(navigator, navController)
    NavHost(
        navController = navController,
        startDestination = NavTarget.SplashScreen.label
    ) {
        composable(NavTarget.SplashScreen.label){
            SplashScreen()
        }
        composable(NavTarget.GetStartedScreen.label){
            GetStartedScreen()
        }
    }
}

@Composable
fun NavigationListener(
    navigator: Navigator,
    navController: NavHostController,
) {
    LaunchedEffect(NAVIGATION) {
        navigator.events.onEach {
            navController.navigate(it.label)
        }.launchIn(this)
    }

}