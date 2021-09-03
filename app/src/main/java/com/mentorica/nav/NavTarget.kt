package com.mentorica.nav

sealed class NavTarget(val label: String) {

    object SplashScreen: NavTarget("splash screen")

}