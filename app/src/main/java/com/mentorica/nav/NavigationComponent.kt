package com.mentorica.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mentorica.models.AuthType
import com.mentorica.screens.get_started.GetStartedScreen
import com.mentorica.screens.login.Login
import com.mentorica.screens.login.LoginScreen
import com.mentorica.screens.splash.SplashScreen
import com.mentorica.utils.NAVIGATION
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@Composable
fun NavigationComponent(
    navigator: Navigator,
    navController: NavHostController,
) {
    NavigationListener(navigator, navController)
    NavHost(
        navController = navController,
        startDestination = NavTarget.SplashScreen.label,
    ) {
        composable(NavTarget.SplashScreen.label) {
            SplashScreen()
        }
        composable(NavTarget.GetStartedScreen.label) {
            GetStartedScreen()
        }
        composable("login/{login_type}") { backStackEntry->
            val authType =
                AuthType.valueOf(backStackEntry.arguments?.getString("login_type").orEmpty())
            LoginScreen(authType = authType)
        }
    }
}

@Composable
fun NavigationListener(
    navigator: Navigator,
    navController: NavHostController,
) {
    LaunchedEffect(NAVIGATION) {
        navigator.events.onEach { target->
            if(target is NavTarget.Main) {
                navController.navigate(target.label, target.navOptionsBuilder)
            } else {
                Timber.e(target.label)
                navController.navigate(target.label)
            }
        }.launchIn(this)
    }
}

