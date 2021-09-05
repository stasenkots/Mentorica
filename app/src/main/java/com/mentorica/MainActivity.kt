package com.mentorica

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.mentorica.nav.Navigator
import com.mentorica.nav.NavigationComponent
import com.mentorica.ui.theme.MentoricaTheme
import com.mentorica.utils.RC_SIGN_IN
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity: ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator

    val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MentoricaTheme {
                Surface(color = MaterialTheme.colors.background) {
                    NavigationComponent(navigator, navController)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN && data != null) {
            viewModel.authenticate(data)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MentoricaTheme {
    }
}