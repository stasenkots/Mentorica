package com.mentorica

import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mentorica.repositories.GoogleServicesRepository
import com.mentorica.utils.launchIO
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val googleServicesRepository: GoogleServicesRepository
    ): ViewModel() {

    fun authenticate(data: Intent) {
        viewModelScope.launchIO {
            googleServicesRepository.authenticate(data)
        }
    }
}