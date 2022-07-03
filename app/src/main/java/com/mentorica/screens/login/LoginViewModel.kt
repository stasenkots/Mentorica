package com.mentorica.screens.login

import android.text.TextUtils
import android.util.Patterns.EMAIL_ADDRESS
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mentorica.R
import com.mentorica.models.AuthType
import com.mentorica.nav.EditScreen
import com.mentorica.nav.Navigator
import com.mentorica.user.UserRepository
import com.mentorica.utils.constants.MIN_PASSWORD_LENGTH
import com.mentorica.utils.constants.MIN_PASSWORD_LENGTH_IS_NOT_REACHED
import com.mentorica.utils.extentions.launchIO
import com.mentorica.utils.extentions.launchUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val navigator: Navigator,
) : ViewModel(), Navigator by navigator {

    val emailState = mutableStateOf("")
    val passwordState = mutableStateOf("")
    var passwordError: MutableState<String?> = mutableStateOf(null)
    var loginError: MutableState<Int?> = mutableStateOf(null)

    var authType: AuthType? = null

    fun authenticate() {
        if (checkLogin() && checkPassword()) {
            loginOrRegister()
        }
    }

    private fun loginOrRegister() {
        checkNotNull(authType) { error("AuthType is not set") }
        viewModelScope.launchIO {
            val email = emailState.value
            val password = passwordState.value
            when (authType) {
                AuthType.Login -> userRepository.login(email, password)
                AuthType.Register -> userRepository.signUp(email, password)
            }
            launchUI {
                if (userRepository.currentUser != null) {
                    navigator.navigateTo(EditScreen)
                }
            }
        }
    }

    private fun checkPassword(): Boolean {
        if (passwordState.value.length < MIN_PASSWORD_LENGTH) {
            passwordError.value = MIN_PASSWORD_LENGTH_IS_NOT_REACHED
            return false
        }
        return true
    }

    private fun checkLogin(): Boolean {
        return if (TextUtils.isEmpty(emailState.value)) {
            false;
        } else {
            if (!EMAIL_ADDRESS.matcher(emailState.value).matches()) {
                loginError.value = R.string.invalid_email_address_error
                false
            } else true
        }
    }
}
