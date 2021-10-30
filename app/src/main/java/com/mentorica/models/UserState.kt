package com.mentorica.models

import androidx.compose.runtime.mutableStateOf

class UserState(
    name: String = "",
    surname: String = "",
    photo: String = "",
    position: String = "",
    description: String = "",
    company: String = "",
    isMentor: Boolean = false,
    payment: String = "",
    technologies: List<String> = emptyList(),
    education: List<String> = emptyList(),
    links: List<String> = emptyList(),
    workExperience: List<WorkExperience> = emptyList(),
) {
    val name = mutableStateOf(name)
    val surname = mutableStateOf(surname)
    val photo = mutableStateOf(photo)
    val position = mutableStateOf(position)
    val description = mutableStateOf(description)
    val company = mutableStateOf(company)
    val isMentor = mutableStateOf(isMentor)
    val payment = mutableStateOf(payment)
    val technologies = mutableStateOf(technologies)
    val education = mutableStateOf(education)
    val links = mutableStateOf(links)
    val workExperience = mutableStateOf(workExperience)
}
