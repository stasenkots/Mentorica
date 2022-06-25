package com.mentorica.models

import java.time.LocalDate

data class Experience(
    val companyName: String,
    val from: LocalDate,
    val to: LocalDate,
    val position: String,
)
