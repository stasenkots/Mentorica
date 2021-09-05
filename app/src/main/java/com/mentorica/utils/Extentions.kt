package com.mentorica.utils

import kotlinx.coroutines.CoroutineExceptionHandler
import timber.log.Timber

val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
    Timber.e(throwable)
}