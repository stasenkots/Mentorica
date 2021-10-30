package com.mentorica.models

data class Payment(val value: Double?) {
    override fun toString(): String {
        return value?.toString().orEmpty()
    }
}
