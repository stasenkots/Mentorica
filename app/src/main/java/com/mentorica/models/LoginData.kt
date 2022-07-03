package com.mentorica.models

import com.google.gson.annotations.SerializedName

data class LoginData(

    @SerializedName("username")
    val email: String,
    val password: String
)
