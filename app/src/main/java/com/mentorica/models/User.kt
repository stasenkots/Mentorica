package com.mentorica.models

data class User(
    val id: String,
    val photo: String,
    val name: String,
    val surname: String,
    val description: String,
    val position: String?,
    val company: String?,
    val isMentor: Boolean,
    val payment: Payment,
    val skills: List<Skill>,
    val workExperience: List<Experience>,
    val education: List<Experience>,
    val links: List<Link>,
    val favorites: List<String>
)
