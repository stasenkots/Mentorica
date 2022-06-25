package com.mentorica.screens.splash

import androidx.lifecycle.ViewModel
import com.mentorica.nav.GetStartedScreen
import com.mentorica.nav.Main
import com.mentorica.nav.Navigator
import com.mentorica.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    navigator: Navigator,
    private val userRepository: UserRepository
): ViewModel(), Navigator by navigator {

    init {
        checkIsUserLoggedIn()
    }

    private fun checkIsUserLoggedIn() {
        if (userRepository.isUserLoggedIn()) {
            navigateTo(Main)
        } else {
            navigateTo(GetStartedScreen)
        }
    }
}
