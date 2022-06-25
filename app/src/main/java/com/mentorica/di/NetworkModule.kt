package com.mentorica.di

import com.mentorica.network.api.UserApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }


    @Provides
    @Singleton
    fun provideUserApi(
        retrofit: Retrofit
    ): UserApi = retrofit.create(UserApi::class.java)



    companion object {
        private const val BASE_URL = "https://mentorica.b4a.io"
    }


}