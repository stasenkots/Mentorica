package com.mentorica.nav

enum class NavTarget(val screenName: String, vararg args: String) {
    SplashScreen("splash"),
    GetStartedScreen("get_started"),
    LoginScreen("login", LOGIN_TYPE),
    EditProfileScreen("edit"),
    Main("main");

    val path: String = NavUtils.composePath(screenName, args.toList())
}
