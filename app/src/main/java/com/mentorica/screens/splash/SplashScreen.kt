package com.mentorica.screens.splash

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SplashScreen(viewModel: SplashScreenViewModel = hiltViewModel()){
    viewModel.navigate()
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SplashScreen()
}
