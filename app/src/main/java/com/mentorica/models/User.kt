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
    val payment: Payment,
    val technologies: List<String>,
    val workExperience: List<Experience>,
    val education: List<Experience>,
    val links: List<Link>,
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
    payment: Payment,
    technologies: List<String>,
    workExperience: List<Experience>,
    education: List<Experience>,
    links: List<Link>,
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
    payment = Payment(null),
    technologies = emptyList(),
    workExperience = emptyList(),
    education = emptyList(),
    links = emptyList()
)

val currentUser: User
    get() = _currentUser!!
