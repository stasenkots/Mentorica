package com.mentorica.screens.splash

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.mentorica.R
import com.mentorica.ui.theme.Blue

@Suppress("UnusedPrivateMember")
@Composable
fun SplashScreen(viewModel: SplashScreenViewModel = hiltViewModel()){
    Splash()
}

@Composable
fun Splash() {
    Surface(
        color = Blue,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(R.drawable.ic_mentorica_logo),
                contentDescription = "",
                alignment = Alignment.Center,
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                text = stringResource(R.string.app_name),
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                textAlign = TextAlign.Center,
                color = Color.White,
                letterSpacing = 1.sp,
            )
        }

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            painter = painterResource(R.drawable.ic_splash_bottom_back),
            contentDescription = "",
            alignment = Alignment.BottomCenter,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Splash()
}
