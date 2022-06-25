package com.mentorica.screens.started

import androidx.lifecycle.ViewModel
import com.mentorica.models.AuthType
import com.mentorica.nav.LoginScreen
import com.mentorica.nav.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GetStartedViewModel @Inject constructor(
    private val navigator: Navigator,
): ViewModel(), Navigator by navigator {

    fun login() {
        navigator.navigateTo(LoginScreen(AuthType.Login))
    }

    fun register() {
        navigator.navigateTo(LoginScreen(AuthType.Register))
    }
}
