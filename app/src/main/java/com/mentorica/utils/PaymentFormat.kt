package com.mentorica.utils

fun getPaymentFormat(payment: Double?): String {
    return if (payment?.rem(1)?.equals(0.0) == true) payment.toInt().toString()
    else payment.toString()
}
