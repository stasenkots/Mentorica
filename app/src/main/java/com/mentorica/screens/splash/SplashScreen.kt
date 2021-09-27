package com.mentorica.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mentorica.R
import com.mentorica.ui.theme.Blue
import com.mentorica.ui.theme.White


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
                color = White,
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
