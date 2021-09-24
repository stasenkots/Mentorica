package com.mentorica.screens.login

import android.text.TextUtils
import android.util.Patterns.EMAIL_ADDRESS
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mentorica.R
import com.mentorica.nav.NavTarget
import com.mentorica.nav.Navigator
import com.mentorica.services.UserLogin
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val navigator: Navigator,
): ViewModel(), Navigator by navigator {

    val email = mutableStateOf("")
    val password = mutableStateOf("")
    var passwordError: MutableState<Int?> = mutableStateOf(null)
    var loginError: MutableState<Int?> = mutableStateOf(null)

    fun authenticate() {
        if(checkLogin() && checkPassword()) {
            UserLogin.data[UserLogin.username] = email
            UserLogin.data[UserLogin.password] = password
            navigator.navigateTo(NavTarget.EditScreen)
        }
    }

    private fun checkPassword(): Boolean {
        if(password.value.length < 8) {
            passwordError.value = R.string.pass_error_1
            return false
        }
        return true
    }

    private fun checkLogin(): Boolean {
        return if (TextUtils.isEmpty(email.value)) {
            false;
        } else {
            if(!EMAIL_ADDRESS.matcher(email.value).matches()){
                loginError.value = R.string.login_error_1
                false
            } else true
        }
    }
}
