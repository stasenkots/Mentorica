package com.mentorica.utils.extentions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

inline fun CoroutineScope.launchIO( crossinline block: suspend CoroutineScope.() -> Unit) {
    launch(exceptionHandler + Dispatchers.IO) {
        block(this)
    }
}

inline fun CoroutineScope.launchUI( crossinline block: suspend CoroutineScope.() -> Unit) {
    launch(exceptionHandler + Dispatchers.Main) {
        block(this)
    }
}

