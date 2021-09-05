package com.mentorica.repositories

import android.content.Intent
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.jackson2.JacksonFactory
import com.mentorica.utils.CLIENT_SECRET
import com.mentorica.utils.REDIRECT_URL
import com.mentorica.utils.SERVER_CLIENT_ID
import com.mentorica.utils.TOKEN_SERVER_ENCODED_URL
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import timber.log.Timber
import javax.inject.Inject

class GoogleServicesRepository @Inject constructor() {

    suspend fun authenticate(data: Intent) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(data)
        val account = task.getResult(ApiException::class.java)
        val authCode = account!!.serverAuthCode
        val tokenResponse = CoroutineScope(Dispatchers.IO).async {
            GoogleAuthorizationCodeTokenRequest(
                NetHttpTransport(),
                JacksonFactory.getDefaultInstance(),
                TOKEN_SERVER_ENCODED_URL,
                SERVER_CLIENT_ID,
                CLIENT_SECRET,
                authCode,
                REDIRECT_URL
            )
                .execute()
        }.await()
        val accessToken: String = tokenResponse.accessToken
        val authData = mapOf(
            "access_token" to accessToken,
            "id" to account.id
        )
        Timber.d("authenticated successfully")
    }

}