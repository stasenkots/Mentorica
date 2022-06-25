package com.mentorica.network.api

import com.mentorica.models.User
import retrofit2.http.GET

interface UserApi {

    @GET("users/myCurrentUserId")
    suspend fun getCurrentUser(): User?
}