package com.mentorica.screens.login

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.mentorica.R
import com.mentorica.models.AuthType
import com.mentorica.ui.components.button.MButton
import com.mentorica.ui.components.text.IconText
import com.mentorica.ui.components.text.PasswordText
import com.mentorica.ui.theme.poppins

@Composable
fun LoginScreen(authType: AuthType, viewModel: LoginViewModel = hiltViewModel()) {
    viewModel.authType = authType
    Login(
        authenticate = viewModel::authenticate,
        authType = authType,
        emailState = viewModel.emailState,
        passwordState = viewModel.passwordState,
        loginErrorState = viewModel.loginError,
        passwordErrorState = viewModel.passwordError
    )
}

@Composable
fun Login(
    authenticate: () -> Unit,
    authType: AuthType,
    emailState: MutableState<String>,
    passwordState: MutableState<String>,
    loginErrorState: MutableState<Int?>,
    passwordErrorState: MutableState<String?>,
) {

    Image(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        painter = painterResource(R.drawable.login),
        contentDescription = "",
        alignment = Alignment.TopCenter,
    )

    val content = buildAnnotatedString {
        append(stringResource(R.string.hey_there) + "\n")
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append(stringResource(R.string.join_community) + " ")
        }
    }
    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            text = content,
            color = Color.White,
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            fontFamily = poppins,
        )
        Spacer(modifier = Modifier.height(400.dp))
        Column(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 40.dp),
        ) {

            Spacer(modifier = Modifier.padding(vertical = 5.dp))

            IconText(
                textState = emailState,
                icon = R.drawable.ic_outline_person_24,
                hint = R.string.login,
                errorState = loginErrorState,
            )

            Spacer(modifier = Modifier.height(10.dp))

            PasswordText(
                passwordState = passwordState,
                errorState = passwordErrorState,
            )

            val buttonText = if(authType == AuthType.Login) {
                stringResource(R.string.login)
            } else {
                stringResource(R.string.register)
            }

            Spacer(modifier = Modifier.height(30.dp))

            MButton(
                modifier = Modifier
                    .width(230.dp)
                    .align(Alignment.CenterHorizontally),
                onClick = authenticate,
                text = buttonText,
            )
            Spacer(modifier = Modifier.height(20.dp))
        }

    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Login(
        { },
        AuthType.Register,
        mutableStateOf("asdasdsad"),
        mutableStateOf(""),
        mutableStateOf(12),
        mutableStateOf(null)
    )
}
