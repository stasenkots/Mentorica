package com.mentorica.models

import java.time.LocalDate

data class Experience(
    val companyName: String,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val position: String
)
