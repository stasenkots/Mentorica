package com.mentorica.ui.get_started

import androidx.lifecycle.ViewModel
import com.mentorica.nav.NavTarget
import com.mentorica.nav.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GetStartedViewModel @Inject constructor(
    private val navigator: Navigator
): ViewModel(), Navigator by navigator {

    fun login() {
        navigator.navigateTo(NavTarget.LoginScreen(NavTarget.LoginScreen.Login))
    }

    fun register(){
        navigator.navigateTo(NavTarget.LoginScreen(NavTarget.LoginScreen.Register))
    }
}