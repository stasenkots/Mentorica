package com.mentorica.ui.splash

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.gms.common.Scopes

import com.google.android.gms.auth.api.signin.GoogleSignInOptions

import android.R
import android.app.Activity
import android.content.Intent
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat.startActivityForResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.mentorica.utils.RC_SIGN_IN
import com.mentorica.utils.SERVER_CLIENT_ID


@Composable
fun SplashScreen(){
    GoogleAuth()
}

@Composable
fun GoogleAuth(){
    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestServerAuthCode(SERVER_CLIENT_ID)
        .requestEmail()
        .build()
    val activity = LocalContext.current as Activity
    val mGoogleSignInClient = GoogleSignIn.getClient(activity, gso)
    val signInIntent: Intent = mGoogleSignInClient.signInIntent
    activity.startActivityForResult(signInIntent, RC_SIGN_IN)

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SplashScreen()
}