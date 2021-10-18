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
    payment: Double? = null,
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
    val payment = mutableStateOf<Double?>(payment)
    val technologies = mutableStateOf<List<String>>(technologies)
    val education = mutableStateOf<List<String>>(education)
    val links = mutableStateOf<List<String>>(links)
    val workExperience = mutableStateOf<List<WorkExperience>>(workExperience)
}
