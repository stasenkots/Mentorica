package com.mentorica.nav

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import timber.log.Timber
import javax.inject.Inject

class NavigatorImpl @Inject constructor(): Navigator {
    private val _sharedFlow =
        MutableSharedFlow<NavRoute>(extraBufferCapacity = 1)
    override val events = _sharedFlow.asSharedFlow()

    override fun navigateTo(navRoute: NavRoute) {
        _sharedFlow.tryEmit(navRoute)
    }
}
