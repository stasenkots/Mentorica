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
        removeFromStateList(user.links, link)
    }

    fun removeSkill(skill: Skill) {
        removeFromStateList(user.skills, skill)
    }

    fun removeEducationExperience(experience: Experience) {
        removeFromStateList(user.education, experience)
    }

    fun removeWorkExperience(experience: Experience) {
        removeFromStateList(user.workExperience, experience)
    }

    private fun validFields(): Boolean {
        var result = true
        if(user.name.value.isBlank()) {
            editErrorState.name.value = R.string.cannot_be_empty
            result = false
        }

        if(user.surname.value.isBlank()) {
            editErrorState.surname.value = R.string.cannot_be_empty
            result = false
        }

        if(user.position.value.isBlank()) {
            editErrorState.position.value = R.string.cannot_be_empty
            result = false
        }

        if(user.description.value.isBlank()) {
            editErrorState.description.value = R.string.cannot_be_empty
            result = false
        }

        if(user.company.value.isBlank()) {
            editErrorState.company.value = R.string.cannot_be_empty
            result = false
        }

        if(user.isMentor.value) {
            if(user.payment.value.isBlank()) {
                editErrorState.payment.value = R.string.cannot_be_empty
                result = false
            }
            else if(user.payment.value.toDoubleOrNull() == null) {
                editErrorState.payment.value = R.string.invalid_input
                result = false
            }
        }

        return result
    }
}
