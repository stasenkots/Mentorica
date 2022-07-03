package com.mentorica.network.api

import com.mentorica.models.LoginData
import com.mentorica.models.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserApi {

    @GET("users/me")
    suspend fun getCurrentUser(): User?

    @POST("users")
    suspend fun signUp(
        @Body
        loginData: LoginData
    ): User

    @GET("login")
    suspend fun login(
        @Query("username")
        email: String,
        @Query("password")
        password: String
    ): User
}
