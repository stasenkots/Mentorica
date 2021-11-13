package com.mentorica.screens.edit_profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mentorica.R
import com.mentorica.models.*
import com.mentorica.nav.NavTarget
import com.mentorica.nav.Navigator
import com.mentorica.repositories.UserRepository
import com.mentorica.utils.launchIO
import com.mentorica.utils.removeFromStateList
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
        payment = currentUser.payment.toString(),
        skills = currentUser.skills,
        education = currentUser.education,
        links = currentUser.links,
        workExperience = currentUser.workExperience,
    )

    val editErrorState = EditErrorState()

    fun saveUserData() {
        if(!validFields()) return
        viewModelScope.launchIO {
            userRepository.saveUserData(
                name = user.name.value,
                surname = user.surname.value,
                photo = user.photo.value,
                position = user.position.value,
                description = user.description.value,
                company = user.company.value,
                isMentor = user.isMentor.value,
                payment = Payment(user.payment.value.toDouble()),
                skills = user.skills.value,
                education = user.education.value,
                links = user.links.value,
                workExperience = user.workExperience.value,
            )

            navigateTo(NavTarget.Main)
        }
    }

    fun removeLink(link: Link) {
    }

    fun removeSkill(skill: Skill) {
    }

    fun removeEducationExperience(experience: Experience) {
    }

    fun removeWorkExperience(experience: Experience) {
    }

    private fun validFields(): Boolean {
        if(user.name.value.isBlank()) {
            editErrorState.name.value = R.string.cannot_be_empty
            return false
        }

        if(user.surname.value.isBlank()) {
            editErrorState.surname.value = R.string.cannot_be_empty
            return false
        }

        if(user.position.value.isBlank()) {
            editErrorState.position.value = R.string.cannot_be_empty
            return false
        }

        if(user.description.value.isBlank()) {
            editErrorState.description.value = R.string.cannot_be_empty
            return false
        }

        if(user.company.value.isBlank()) {
            editErrorState.company.value = R.string.cannot_be_empty
            return false
        }

        if(user.payment.value.toDoubleOrNull() == null) {
            editErrorState.payment.value = R.string.invalid_input
            return false
        }

        return true
    }
}
