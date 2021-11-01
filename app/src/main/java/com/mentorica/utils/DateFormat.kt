package com.mentorica.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun formatToMonthYear(date: LocalDate): String {
    val formatter = DateTimeFormatter.ofPattern("LLL. yyyy")
    return date.format(formatter)
}
