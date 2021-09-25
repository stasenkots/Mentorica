package com.mentorica.screens.edit_profile

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mentorica.models.WorkExperience
import com.mentorica.models.currentUser
import com.mentorica.nav.NavTarget
import com.mentorica.nav.Navigator
import com.mentorica.repositories.UserRepository
import com.mentorica.services.UserLogin
import com.mentorica.utils.launchIO
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EditProfileViewModel @Inject constructor(
    private val userRepository: UserRepository,
    navigator: Navigator
): ViewModel(), Navigator by navigator {

    val name = mutableStateOf(currentUser.name)
    val surname = mutableStateOf(currentUser.surname)
    val photo = mutableStateOf(currentUser.photo)
    val position = mutableStateOf(currentUser.position)
    val description = mutableStateOf(currentUser.description)
    val company = mutableStateOf(currentUser.company)
    val isMentor = mutableStateOf(currentUser.isMentor)
    val payment = mutableStateOf(currentUser.payment)
    val technologies = mutableStateOf(currentUser.technologies)
    val education = mutableStateOf(currentUser.education)
    val links = mutableStateOf(currentUser.links)
    val workExperience = mutableStateOf(currentUser.workExperience)

    fun saveUserData() {
        viewModelScope.launchIO {
            userRepository.saveUserData(
                name = name.value,
                surname = surname.value,
                photo = photo.value,
                position = position.value,
                description = description.value,
                company = company.value,
                isMentor = isMentor.value,
                payment = payment.value,
                technologies = technologies.value,
                education = education.value,
                links = links.value,
                workExperience = workExperience.value,
            )

            navigateTo(NavTarget.Main)
        }
    }
}
