package com.mentorica.nav

import kotlinx.coroutines.flow.SharedFlow

interface Navigator {

    val events: SharedFlow<NavRoute>

    fun navigateTo(navRoute: NavRoute)

}
