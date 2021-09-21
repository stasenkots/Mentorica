package com.mentorica.models

import com.mentorica.nav.LOGIN_TYPE

enum class AuthType(val value: String) {
    Login("login"),
    Register("register"),
    None("{$LOGIN_TYPE}")
}
