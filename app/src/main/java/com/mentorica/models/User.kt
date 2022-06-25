package com.mentorica.models

data class User(
    val id:String,
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
    val favorites:List<String>
)