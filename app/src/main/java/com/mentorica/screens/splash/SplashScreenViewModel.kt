package com.mentorica.screens.splash

import androidx.lifecycle.ViewModel
import com.mentorica.models.AuthType
import com.mentorica.nav.NavTarget
import com.mentorica.nav.Navigator
import com.mentorica.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val navigator: Navigator,
    private val userRepository: UserRepository
): ViewModel(), Navigator by navigator {

    init {
        checkIsUserLoggedIn()
    }

    fun checkIsUserLoggedIn() {
        if (userRepository.isUserLoggedIn()) {
            navigator.navigateTo(NavTarget.Main)
        } else {
            navigator.navigateTo(NavTarget.GetStartedScreen)
        }
    }
}
