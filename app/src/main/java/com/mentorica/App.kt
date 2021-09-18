package com.mentorica

import android.app.Application
import com.parse.Parse
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App: Application(){

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        Parse.initialize(
            Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.back4app_app_id))
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build()
        )


    }
}
