package com.mentorica.screens.login

import android.util.Log
import androidx.lifecycle.ViewModel
import com.mentorica.nav.NavTarget
import com.mentorica.nav.Navigator
import com.mentorica.repositories.UserRepository
import com.mentorica.services.UserLogin
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val navigator: Navigator
): ViewModel(), Navigator by navigator {

    fun authenticate(username: String, password: String) {
        UserLogin.data[UserLogin.username] = username
        UserLogin.data[UserLogin.password] = password
        navigator.navigateTo(NavTarget.EditScreen)
    }
}
