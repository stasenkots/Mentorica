package com.mentorica.nav

import androidx.navigation.NavOptions
import com.mentorica.models.AuthType

sealed class NavTarget(val label: String) {

    object SplashScreen: NavTarget("splash")
    object GetStartedScreen: NavTarget("get started")
    class LoginScreen(authType: AuthType = AuthType.None): NavTarget("login/${authType.value}")
    object Main: NavTarget("main") {
        val navOptionsBuilder = NavOptions.Builder()
            .setLaunchSingleTop(true)
            .setPopUpTo(SplashScreen.label, true)
            .build()
    }

    object EditScreen: NavTarget("edit")
}
