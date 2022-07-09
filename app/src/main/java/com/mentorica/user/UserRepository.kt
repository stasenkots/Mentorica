package com.mentorica.user

import com.mentorica.models.LoginData
import com.mentorica.models.User
import com.mentorica.network.api.UserApi
import com.mentorica.network.mapping.UserMapper
import retrofit2.HttpException
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val userApi: UserApi,
    private val mapper: UserMapper
) {

    var currentUser: User? = null
        private set

    fun isUserLoggedIn() = currentUser != null

    suspend fun login(email: String, password: String) {
        val userDto = userApi.login(email, password)
        currentUser = mapper.map(userDto)
    }

    suspend fun signUp(email: String, password: String) {
        val loginData = LoginData(email, password)
        val userDto = userApi.signUp(loginData)
        currentUser = mapper.map(userDto)
    }

    suspend fun update(user: User) {
        val userDto = mapper.map(user)
        userApi.update(user.id, userDto)
    }

    suspend fun initCurrentUser() {
        try {
            val userDto = userApi.getCurrentUser() ?: return
            currentUser = mapper.map(userDto)
        } catch (exception: HttpException) {
            Timber.d(exception)
        }
    }
}
