package com.mentorica.nav

import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder

sealed class NavTarget(val label: String) {

    object SplashScreen: NavTarget("splash")
    object GetStartedScreen: NavTarget("get started")
    class LoginScreen(type: Type = None): NavTarget("login/${type.value}") {
        sealed class Type(val value: String)
        object Login: Type("login")
        object Register: Type("register")
        private object None: Type("{login_type}")
    }

    object Main: NavTarget("main"){
        val navOptionsBuilder = NavOptions.Builder()
            .setLaunchSingleTop(true)
            .setPopUpTo(SplashScreen.label,true)
            .build()
    }
}
