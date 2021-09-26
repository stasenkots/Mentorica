package com.mentorica.services

import com.parse.ParseUser
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ParseService @Inject constructor() {

    suspend fun login(username: String, password: String) {
        ParseUser.logIn(username, password)
    }

    suspend fun register(username: String, password: String) {
        val user = ParseUser()
        user.username = username
        user.setPassword(password)
        user.signUp()
    }
}
