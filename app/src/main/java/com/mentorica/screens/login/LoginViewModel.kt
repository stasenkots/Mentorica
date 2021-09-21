package com.mentorica.screens.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mentorica.nav.NavTarget
import com.mentorica.nav.Navigator
import com.mentorica.services.UserLogin
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val navigator: Navigator
): ViewModel(), Navigator by navigator {

    val email = mutableStateOf("")
    val password = mutableStateOf("")

    fun authenticate() {
        UserLogin.data[UserLogin.username] = email
        UserLogin.data[UserLogin.password] = password
        navigator.navigateTo(NavTarget.EditScreen)
    }
}
