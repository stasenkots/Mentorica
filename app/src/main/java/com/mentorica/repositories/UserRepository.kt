package com.mentorica.repositories

import com.mentorica.models.*
import com.mentorica.services.ParseService
import com.mentorica.services.UserLogin
import com.parse.ParseUser
import com.parse.ktx.putOrIgnore
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val parseService: ParseService) {

    fun isUserLoggedIn() = ParseUser.getCurrentUser() != null

    suspend fun authenticate(username: String, password: String, authType: AuthType) {
        if(authType == AuthType.login) {
            parseService.login(username, password)
        } else if(authType == AuthType.register) {
            parseService.register(username, password)
        }
    }
}
