package com.mentorica.nav

import kotlinx.coroutines.flow.SharedFlow

interface Navigator {
    val sharedFlow: SharedFlow<NavTarget>

    fun navigateTo(navTarget: NavTarget)
}