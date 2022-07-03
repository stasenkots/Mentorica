package com.mentorica.utils.extentions

import androidx.compose.runtime.*
import kotlinx.coroutines.CoroutineExceptionHandler
import timber.log.Timber

var errorBus = mutableStateOf<Throwable?>(null)

val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
    errorBus.value = throwable
    Timber.e(throwable)
}
