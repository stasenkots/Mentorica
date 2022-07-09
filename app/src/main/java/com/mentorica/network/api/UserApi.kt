package com.mentorica.network.api

import com.mentorica.models.LoginData
import com.mentorica.network.dto.UserDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface UserApi {

    @GET("users/me")
    suspend fun getCurrentUser(): UserDto?

    @POST("users")
    suspend fun signUp(
        @Body
        loginData: LoginData
    ): UserDto

    @GET("login")
    suspend fun login(
        @Query("username")
        email: String,
        @Query("password")
        password: String
    ): UserDto

    @PUT("users/{id}")
    suspend fun update(
        @Path("id")
        id: String,
        @Body
        user: UserDto
    ): UserDto
}
