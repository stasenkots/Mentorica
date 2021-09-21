package com.mentorica

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.mentorica.nav.Navigator
import com.mentorica.nav.NavigationComponent
import com.mentorica.ui.theme.MentoricaTheme
import com.mentorica.utils.GlobalStates.errorBus
import com.mentorica.utils.RC_SIGN_IN
import com.parse.google.ParseGoogleUtils
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity: ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MentoricaTheme {
                Surface(color = MaterialTheme.colors.background) {
                    NavigationComponent(navigator, navController)
                    if (errorBus.value != null) {
                        ShowError(errorBus.value?.message)
                    }
                }
            }
        }
    }


    @Composable
    fun ShowError(error: String?) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MentoricaTheme {
    }
}
