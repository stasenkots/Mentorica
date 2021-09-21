package com.mentorica.models

import com.mentorica.nav.LOGIN_TYPE

enum class AuthType(val value: String) {
    login("login"),
    register("register"),
    none("{$LOGIN_TYPE}")
}
