package com.mentorica.repositories

import com.mentorica.models.User
import com.mentorica.network.api.UserApi
import com.mentorica.services.ParseService
import com.parse.ParseUser
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val parseService: ParseService,
    private val userApi: UserApi
) {

    fun isUserLoggedIn() = ParseUser.getCurrentUser() != null

    suspend fun login(email: String, password: String) {
        parseService.login(email, password)
    }

    suspend fun register(email: String, password: String) {
        parseService.register(email, password)
    }

    suspend fun getCurrentUser(): User? {
        return userApi.getCurrentUser()
    }
}
