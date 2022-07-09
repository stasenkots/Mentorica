package com.mentorica.nav

import androidx.navigation.NavOptions
import com.mentorica.models.AuthType

sealed class NavRoute(val path: String, val navOptions: NavOptions? = null)

object SplashScreen: NavRoute(NavTarget.SplashScreen.screenName)
object GetStartedScreen: NavRoute(NavTarget.GetStartedScreen.screenName)
class LoginScreen(authType: AuthType): NavRoute(
    NavTarget.LoginScreen.screenName + "/$authType",
)

object Main: NavRoute(
    NavTarget.SplashScreen.name,
    NavOptions.Builder()
        .setLaunchSingleTop(true)
        .setPopUpTo(SplashScreen.path, true)
        .build(),
)

object EditScreen: NavRoute(NavTarget.EditProfileScreen.screenName)
