package com.mentorica.di

import com.mentorica.network.Header
import com.mentorica.network.api.UserApi
import com.mentorica.utils.constants.ServerConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideClient(): OkHttpClient {

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request()
                val newRequest = request.newBuilder()
                    .addHeader(Header.APPLICATION_ID, ServerConstants.APP_ID)
                    .addHeader(Header.API_KEY, ServerConstants.REST_API_KET)
                    .addHeader(Header.REVOCABLE_SESSION, ServerConstants.REVOCABLE_SESSION)
                    .addHeader(Header.CONTENT_TYPE, ServerConstants.CONTENT_TYPE)
                    .build()
                chain.proceed(newRequest)
            }
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(ServerConstants.BASE_URL)
            .client(okHttpClient)
            .build()
    }


    @Provides
    @Singleton
    fun provideUserApi(
        retrofit: Retrofit
    ): UserApi = retrofit.create(UserApi::class.java)
}
