package com.mentorica.screens.edit_profile

import com.mentorica.R
import com.mentorica.models.UserState
import javax.inject.Inject

class UserFieldsValidator @Inject constructor() {

    fun isFieldsValid(
        userState: UserState,
        editErrorState: EditErrorState
    ):Boolean {
        var result = true
        if (userState.name.value.isBlank()) {
            editErrorState.name.value = R.string.cannot_be_empty
            result = false
        }

        if (userState.surname.value.isBlank()) {
            editErrorState.surname.value = R.string.cannot_be_empty
            result = false
        }

        if (userState.position.value.isNullOrBlank()) {
            editErrorState.position.value = R.string.cannot_be_empty
            result = false
        }

        if (userState.description.value.isBlank()) {
            editErrorState.description.value = R.string.cannot_be_empty
            result = false
        }

        if (userState.company.value.isNullOrBlank()) {
            editErrorState.company.value = R.string.cannot_be_empty
            result = false
        }

        if (userState.isMentor.value) {
            if (userState.payment.value.isBlank()) {
                editErrorState.payment.value = R.string.cannot_be_empty
                result = false
            }
        }

        return result
    }
}
