package com.mentorica.nav

import androidx.navigation.NavOptionsBuilder
import com.mentorica.models.AuthType

sealed class NavRoute(val path: String, val navOptions: NavOptionsBuilder.() -> Unit = {})

object SplashScreen: NavRoute(NavTarget.SplashScreen.screenName)
object GetStartedScreen: NavRoute(NavTarget.GetStartedScreen.screenName)
class LoginScreen(authType: AuthType): NavRoute(
    NavTarget.LoginScreen.screenName + "/$authType",
)

object MainScreen: NavRoute(
    NavTarget.MainScreen.screenName,
    { popUpTo(MainScreen.path) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
)

object EditScreen: NavRoute(NavTarget.EditProfileScreen.screenName)
