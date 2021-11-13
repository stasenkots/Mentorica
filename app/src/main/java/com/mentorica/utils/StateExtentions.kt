package com.mentorica.utils

import androidx.compose.runtime.MutableState

fun <T> removeFromStateList(state: MutableState<List<T>>, value: T) {
    val list = state.value.toMutableList()
    list.remove(value)
    state.value = list
}
