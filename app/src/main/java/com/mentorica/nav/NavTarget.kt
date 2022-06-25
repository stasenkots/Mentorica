package com.mentorica.nav

enum class NavTarget(val screenName: String, vararg args: String) {
    SplashScreen("splash"),
    GetStartedScreen("get started"),
    LoginScreen("login", LOGIN_TYPE),
    EditScreen("edit"),
    Main("main");

    val path: String = NavUtils.composePath(screenName, args.toList())
}
