package com.mentorica.nav

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

class NavigatorImpl @Inject constructor(): Navigator {
    private val _sharedFlow =
        MutableSharedFlow<NavTarget>(extraBufferCapacity = 1)
    override val sharedFlow = _sharedFlow.asSharedFlow()

    override fun navigateTo(navTarget: NavTarget) {
        _sharedFlow.tryEmit(navTarget)
    }
}