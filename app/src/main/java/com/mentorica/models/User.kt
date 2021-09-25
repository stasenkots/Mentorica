package com.mentorica.models

data class User(
    val id: String,
    val photo: String,
    val name: String,
    val surname: String,
    val description: String,
    val position: String,
    val company: String,
    val isMentor: Boolean,
    val payment: Double?,
    val technologies: List<String>,
    val workExperience: List<WorkExperience>,
    val education: List<String>,
    val links: List<String>,
)

fun setCurrentUser(
    id: String,
    photo: String,
    name: String,
    surname: String,
    description: String,
    position: String,
    company: String,
    isMentor: Boolean,
    payment: Double?,
    technologies: List<String>,
    workExperience: List<WorkExperience>,
    education: List<String>,
    links: List<String>,
) {
    _currentUser = User(
        id = id,
        photo = photo,
        name = name,
        surname = surname,
        description = description,
        position = position,
        company = company,
        isMentor = isMentor,
        payment = payment,
        technologies = technologies,
        workExperience = workExperience,
        education = education,
        links = links,
    )
}

private var _currentUser: User = emptyUser()

fun emptyUser() = User(
    id = "",
    name = "",
    surname = "",
    photo = "",
    description = "",
    position = "",
    company = "",
    isMentor = false,
    payment = 0.0,
    technologies = emptyList(),
    workExperience = emptyList(),
    education = emptyList(),
    links = emptyList()
)

val currentUser: User
    get() = _currentUser!!
