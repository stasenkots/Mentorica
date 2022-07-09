package com.mentorica.models

data class Payment(val amount: Double?) {
    override fun toString(): String {
        return amount?.toString().orEmpty()
    }

    fun isBlank(): Boolean{
        return amount != null
    }
}
