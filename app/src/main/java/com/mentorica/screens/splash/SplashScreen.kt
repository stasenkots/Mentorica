package com.mentorica.screens.splash

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SplashScreen(viewModel: SplashScreenViewModel = hiltViewModel()){
    Button(onClick = viewModel::navigate) {
        Text(text = "Click")
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SplashScreen()
}
