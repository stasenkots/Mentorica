package com.mentorica.models

import androidx.compose.runtime.*

class UserState(user: User) {
    val id = user.id
    val name = mutableStateOf(user.name)
    val surname = mutableStateOf(user.surname)
    val photo = mutableStateOf(user.photo)
    val position = mutableStateOf(user.position)
    val description = mutableStateOf(user.description)
    val company = mutableStateOf(user.company)
    val isMentor = mutableStateOf(user.isMentor)
    val payment = mutableStateOf(user.payment.toString())
    val skills = mutableStateOf(user.skills)
    val education = mutableStateOf(user.education)
    val links = mutableStateOf(user.links)
    val workExperience = mutableStateOf(user.workExperience)

    fun getUser(): User{
        return User(
            name = name.value,
            surname = surname.value,
            photo = photo.value,
            position = position.value,
            description = description.value,
            company = company.value,
            isMentor = isMentor.value,
            payment = Payment(payment.value.toDouble()),
            skills = skills.value,
            education = education.value,
            links = links.value,
            workExperience = workExperience.value,
            favorites = emptyList(),
            id = id
        )
    }
}
