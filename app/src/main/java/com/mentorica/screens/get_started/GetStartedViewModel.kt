package com.mentorica.screens.get_started

import androidx.lifecycle.ViewModel
import com.mentorica.models.AuthType
import com.mentorica.nav.NavTarget
import com.mentorica.nav.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GetStartedViewModel @Inject constructor(
    private val navigator: Navigator
): ViewModel(), Navigator by navigator {

    fun login() {
        navigator.navigateTo(NavTarget.LoginScreen(AuthType.login))
    }

    fun register(){
        navigator.navigateTo(NavTarget.LoginScreen(AuthType.register))
    }
}
