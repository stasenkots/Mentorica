package com.mentorica.nav

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mentorica.models.AuthType
import com.mentorica.screens.started.GetStartedScreen
import com.mentorica.screens.login.LoginScreen
import com.mentorica.screens.splash.SplashScreen
import com.mentorica.utils.constants.NAVIGATION
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
        startDestination = NavTarget.SplashScreen.path,
    ) {
        composable(NavTarget.SplashScreen.path) {
            SplashScreen()
        }
        composable(NavTarget.GetStartedScreen.path) {
            GetStartedScreen()
        }
        composable(NavTarget.LoginScreen.path) { backStackEntry->
            val arguments = backStackEntry.arguments ?: Bundle.EMPTY
            val authType = AuthType.valueOf(arguments.getString(LOGIN_TYPE).orEmpty())
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
            Timber.d("Navigate to ${target.path}")
            navController.navigate(target.path, target.navOptions)
        }.launchIn(this)
    }
}

