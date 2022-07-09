package com.mentorica.network.dto

import java.time.LocalDate

data class ExperienceDto(
    val companyName: String,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val position: String
)
