package com.mentorica.network.dto

import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("objectId")
    val id: String,
    @SerializedName("photo")
    val photo: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("surname")
    val surname: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("position")
    val position: String?,
    @SerializedName("company")
    val company: String?,
    @SerializedName("mentor")
    val isMentor: Boolean,
    @SerializedName("payment")
    val payment: Double?,
    @SerializedName("skills")
    val skills: List<String>,
    @SerializedName("work_experience")
    val workExperience: List<ExperienceDto>,
    @SerializedName("education")
    val education: List<ExperienceDto>,
    @SerializedName("links")
    val links: List<LinkDto>,
    @SerializedName("favorites")
    val favorites: List<String>
)
