package com.mentorica.user

import com.mentorica.models.LoginData
import com.mentorica.models.User
import com.mentorica.network.api.UserApi
import retrofit2.HttpException
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val userApi: UserApi,
) {

    var currentUser: User? = null
        private set

    fun isUserLoggedIn() = currentUser != null

    suspend fun login(email: String, password: String) {
        currentUser = userApi.login(email, password)
    }

    suspend fun signUp(email: String, password: String) {
        val loginData = LoginData(email, password)
        currentUser = userApi.signUp(loginData)
    }

    suspend fun initCurrentUser() {
        try {
            currentUser = userApi.getCurrentUser()
        } catch (exception: HttpException) {
            Timber.d(exception)
        }
    }
}
