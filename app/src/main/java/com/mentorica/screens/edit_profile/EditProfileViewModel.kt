package com.mentorica.screens.edit_profile

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mentorica.models.UserState
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
    navigator: Navigator,
): ViewModel(), Navigator by navigator {

    val user = UserState(
        name = currentUser.name,
        surname = currentUser.surname,
        photo = currentUser.photo,
        position = currentUser.position,
        description = currentUser.description,
        company = currentUser.company,
        isMentor = currentUser.isMentor,
        payment = currentUser.payment,
        technologies = currentUser.technologies,
        education = currentUser.education,
        links = currentUser.links,
        workExperience = currentUser.workExperience,
    )

    val editErrorState = EditErrorState()

    fun saveUserData() {
        viewModelScope.launchIO {
            userRepository.saveUserData(
                name = user.name.value,
                surname = user.surname.value,
                photo = user.photo.value,
                position = user.position.value,
                description = user.description.value,
                company = user.company.value,
                isMentor = user.isMentor.value,
                payment = user.payment.value,
                technologies = user.technologies.value,
                education = user.education.value,
                links = user.links.value,
                workExperience = user.workExperience.value,
            )

            navigateTo(NavTarget.Main)
        }
    }
}
