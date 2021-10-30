package com.mentorica.screens.edit_profile

import androidx.compose.runtime.mutableStateOf

class EditErrorState {
    val name = mutableStateOf<Int?>(null)
    val surname = mutableStateOf<Int?>(null)
    val description = mutableStateOf<Int?>(null)
    val position = mutableStateOf<Int?>(null)
    val company = mutableStateOf<Int?>(null)
    val payment = mutableStateOf<Int?>(null)
}
