package com.mentorica.utils

import androidx.compose.runtime.mutableStateOf

object GlobalStates{
    var errorBus = mutableStateOf<Throwable?>(null)
}