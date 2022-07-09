package com.mentorica.utils.extentions

import androidx.compose.runtime.*

fun <T> removeFromStateList(state: MutableState<List<T>>, value: T) {
    val list = state.value.toMutableList()
    list.remove(value)
    state.value = list
}
