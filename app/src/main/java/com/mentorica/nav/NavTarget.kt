package com.mentorica.nav

sealed class NavTarget(val label: String) {

    object SplashScreen: NavTarget("splash")
    object GetStartedScreen: NavTarget("get started")
    class LoginScreen(type: Type = None): NavTarget("login/${type.value}") {
        sealed class Type(val value: String)
        object Login: Type("login")
        object Register: Type("register")
        object None: Type("{login_type}")
    }

}