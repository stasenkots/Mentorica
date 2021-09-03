package com.mentorica.di

import com.mentorica.nav.Navigator
import com.mentorica.nav.NavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @Binds
    @Singleton
    fun navigator(navigatorImpl: NavigatorImpl): Navigator

}