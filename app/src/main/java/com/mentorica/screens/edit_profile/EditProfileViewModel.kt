package com.mentorica.screens.edit_profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mentorica.models.Experience
import com.mentorica.models.Link
import com.mentorica.models.Skill
import com.mentorica.models.UserState
import com.mentorica.nav.MainScreen
import com.mentorica.nav.Navigator
import com.mentorica.user.UserRepository
import com.mentorica.utils.extentions.launchIO
import com.mentorica.utils.extentions.removeFromStateList
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class EditProfileViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val userFieldsValidator: UserFieldsValidator,
    navigator: Navigator,
) : ViewModel(), Navigator by navigator {

    val userState = UserState(userRepository.currentUser ?: error("User is null"))

    val editErrorState = EditErrorState()

    fun saveUserData() {
        if (!validFields()) {
            return
        }
        viewModelScope.launchIO {
            userRepository.update(userState.getUser())
            navigateTo(MainScreen)
        }
    }

    fun removeLink(link: Link) {
        removeFromStateList(userState.links, link)
    }

    fun removeSkill(skill: Skill) {
        removeFromStateList(userState.skills, skill)
    }

    fun removeEducationExperience(experience: Experience) {
        removeFromStateList(userState.education, experience)
    }

    fun removeWorkExperience(experience: Experience) {
        removeFromStateList(userState.workExperience, experience)
    }

    private fun validFields(): Boolean {
        return userFieldsValidator.isFieldsValid(userState, editErrorState)
    }
}
