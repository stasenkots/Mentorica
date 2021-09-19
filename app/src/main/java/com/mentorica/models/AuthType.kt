package com.mentorica.models

enum class AuthType(val value: String) {
    Login("login"),
    Register("register"),
    None("{login_type}")
}
