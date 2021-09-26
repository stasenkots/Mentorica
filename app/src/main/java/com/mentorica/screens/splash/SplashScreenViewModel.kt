package com.mentorica.screens.splash

import androidx.lifecycle.ViewModel
import com.mentorica.models.AuthType
import com.mentorica.nav.NavTarget
import com.mentorica.nav.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    val navigator: Navigator
): ViewModel(), Navigator by navigator {

    fun navigate(){
        navigator.navigateTo(NavTarget.LoginScreen(AuthType.register))
    }
}
