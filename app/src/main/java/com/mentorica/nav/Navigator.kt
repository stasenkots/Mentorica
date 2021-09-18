package com.mentorica.nav

import kotlinx.coroutines.flow.SharedFlow

interface Navigator {

    val events: SharedFlow<NavTarget>

    fun navigateTo(navTarget: NavTarget)
}