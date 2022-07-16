package com.mentorica.nav

import android.os.Bundle
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mentorica.models.AuthType
import com.mentorica.screens.edit_profile.EditProfileScreen
import com.mentorica.screens.login.LoginScreen
import com.mentorica.screens.main.MainScreen
import com.mentorica.screens.splash.SplashScreen
import com.mentorica.screens.started.GetStartedScreen
import com.mentorica.utils.constants.NAVIGATION
import kotlinx.coroutines.cancel
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

        composable(NavTarget.LoginScreen.path) { backStackEntry ->
            val arguments = backStackEntry.arguments ?: Bundle.EMPTY
            val authType = AuthType.valueOf(arguments.getString(LOGIN_TYPE).orEmpty())
            LoginScreen(authType = authType)
        }

        composable(NavTarget.EditProfileScreen.path) {
            EditProfileScreen()
        }

        composable(NavTarget.MainScreen.path) {
            MainScreen()
        }
    }
}

@Composable
fun NavigationListener(
    navigator: Navigator,
    navController: NavHostController,
) {
    LaunchedEffect(NAVIGATION) {
        navigator.events.onEach { target ->
            if (target.path == NavTarget.MainScreen.path){
                cancel()
            }
            Timber.d("Navigate to ${target.path}")
            navController.navigate(target.path, target.navOptions)
        }.launchIn(this)
    }
}

