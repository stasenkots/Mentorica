package com.mentorica.screens.main

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.*
import com.mentorica.nav.BottomNavItem
import com.mentorica.ui.theme.BlueLight

@Composable
fun BottomNavigationBar(
    navItems: List<BottomNavItem>,
    navigateTo: (BottomNavItem) -> Unit
) {

    var selectedItem: BottomNavItem by remember { mutableStateOf(BottomNavItem.HomeScreen) }

    BottomNavigation(
        backgroundColor = BlueLight,
        contentColor = Color.White
    ) {
        navItems.forEach { navItem ->
            BottomNavigationItem(
                selected = selectedItem == navItem,
                onClick = {
                    selectedItem = navItem
                    navigateTo(navItem)
                },
                icon = {
                    val iconId = if (selectedItem == navItem) {
                        navItem.filledIcon
                    } else {
                        navItem.outlinedIcon
                    }
                    
                    Icon(painter = painterResource(id = iconId), contentDescription = null)
                }
            )
        }
    }
}
//
//@SuppressLint("UnrememberedMutableState")
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreviewBottomNavigationBar() {
//    BottomNavigationBar(
//        listOf(
//            BottomNavItem.HomeScreen,
//            BottomNavItem.FavoritesScreen
//        )
//    remember) {}
//}
