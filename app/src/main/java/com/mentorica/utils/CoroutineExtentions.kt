package com.mentorica.utils

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
    GlobalStates.errorBus.value = throwable
    Timber.e(throwable)
}

inline fun CoroutineScope.launchIO( crossinline func: suspend () -> Unit) {
    launch(exceptionHandler + Dispatchers.IO) {
        func()
    }
}
