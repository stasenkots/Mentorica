package com.mentorica.models

import java.time.LocalDate

data class WorkExperience(
    val from: LocalDate,
    val to: LocalDate,
    val companyName: String,
)
