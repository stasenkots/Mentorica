package com.mentorica.screens.login

import android.text.TextUtils
import android.util.Patterns.EMAIL_ADDRESS
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.mentorica.R
import com.mentorica.nav.EditScreen
import com.mentorica.nav.Navigator
import com.mentorica.services.UserLogin
import com.mentorica.utils.constants.MIN_PASSWORD_LENGTH
import com.mentorica.utils.constants.MIN_PASSWORD_LENGTH_IS_NOT_REACHED
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val navigator: Navigator,
) : ViewModel(), Navigator by navigator {

    val email = mutableStateOf("")
    val password = mutableStateOf("")
    var passwordError: MutableState<String?> = mutableStateOf(null)
    var loginError: MutableState<Int?> = mutableStateOf(null)

    fun authenticate() {
        if (checkLogin() && checkPassword()) {
            UserLogin.data[UserLogin.username] = email
            UserLogin.data[UserLogin.password] = password
            navigator.navigateTo(EditScreen)
        }
    }

    private fun checkPassword(): Boolean {
        if (password.value.length < MIN_PASSWORD_LENGTH) {
            passwordError.value = MIN_PASSWORD_LENGTH_IS_NOT_REACHED
            return false
        }
        return true
    }

    private fun checkLogin(): Boolean {
        return if (TextUtils.isEmpty(email.value)) {
            false;
        } else {
            if (!EMAIL_ADDRESS.matcher(email.value).matches()) {
                loginError.value = R.string.invalid_email_address_error
                false
            } else true
        }
    }

    companion object {

    }
}
