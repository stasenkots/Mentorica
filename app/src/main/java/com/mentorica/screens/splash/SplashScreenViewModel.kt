package com.mentorica.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mentorica.nav.GetStartedScreen
import com.mentorica.nav.Main
import com.mentorica.nav.Navigator
import com.mentorica.user.UserRepository
import com.mentorica.utils.extentions.launchIO
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    navigator: Navigator,
    private val userRepository: UserRepository
) : ViewModel(), Navigator by navigator {

    init {
        viewModelScope.launchIO {
            userRepository.initCurrentUser()
            checkIsUserLoggedIn()
        }
    }

    private fun checkIsUserLoggedIn() {
        if (userRepository.isUserLoggedIn()) {
            navigateTo(Main)
        } else {
            navigateTo(GetStartedScreen)
        }
    }
}
