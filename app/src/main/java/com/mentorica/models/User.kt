package com.mentorica.models

data class User(
    val photo: String,
    val name: String,
    val surname: String,
    val description: String,
    val position: String,
    val company: String,
    val isMentor: Boolean,
    val payment: Double?,
    val technologies: List<String>,
    val workExperience: List<Experience>,
    val education: List<Experience>,
    val links: List<String>,
)

fun setCurrentUser(
    photo: String,
    name: String,
    surname: String,
    description: String,
    position: String,
    company: String,
    isMentor: Boolean,
    payment: Double?,
    technologies: List<String>,
    workExperience: List<Experience>,
    education: List<Experience>,
    links: List<String>,
) {
    _currentUser = User(
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

private var _currentUser: User? = null

val currentUser: User
    get() = _currentUser!!
