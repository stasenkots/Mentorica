package com.mentorica.nav

import androidx.annotation.DrawableRes
import com.mentorica.R

sealed class BottomNavItem(
    route: String,
    @DrawableRes val filledIcon: Int,
    @DrawableRes val outlinedIcon: Int,
) : NavRoute(
    route,
    {
        popUpTo(NavTarget.HomeScreen.path) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
) {
    object HomeScreen : BottomNavItem(
        NavTarget.HomeScreen.path,
        R.drawable.ic_nav_home_filled,
        R.drawable.ic_nav_home_outlined
    )

    object FavoritesScreen : BottomNavItem(
        NavTarget.FavoritesScreen.path,
        R.drawable.ic_nav_favorite_filled,
        R.drawable.ic_nav_favorite_outlined
    )

}
