package com.mentorica.screens.main

import androidx.lifecycle.ViewModel
import com.mentorica.nav.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val navigator: Navigator
): ViewModel() {

}
