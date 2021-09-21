package com.mentorica.screens.login

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mentorica.R
import com.mentorica.models.AuthType
import com.mentorica.ui.components.MButton
import com.mentorica.ui.theme.Blue
import com.mentorica.ui.theme.poppins

@Composable
fun LoginScreen(authType: AuthType, viewModel: LoginViewModel = hiltViewModel()) {
    Login(
        authenticate = viewModel::authenticate,
        authType = authType,
        emailState = viewModel.email,
        passwordState = viewModel.password,
    )
}

@Composable
fun Login(
    authenticate: () -> Unit,
    authType: AuthType,
    emailState: MutableState<String>,
    passwordState: MutableState<String>,
) {

    var email by remember { emailState }
    var password by remember { passwordState }
    var passwordVisibility by remember { mutableStateOf(true) }


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
        Spacer(modifier = Modifier.height(450.dp))
        Column(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 40.dp),
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = email,
                onValueChange = { email = it },
                label = { Text(text = stringResource(R.string.email)) },
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_outline_person_24),
                        contentDescription = "",
                    )
                },
                shape = CircleShape,
                colors = outlinedTextFieldColors(
                    focusedBorderColor = Blue,
                    focusedLabelColor = Blue,
                ),
            )
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                onValueChange = { password = it },
                label = { Text(text = stringResource(R.string.password)) },
                trailingIcon = {
                    val image = if(passwordVisibility)
                        Icons.Outlined.Visibility
                    else Icons.Filled.VisibilityOff

                    IconButton(
                        onClick = { passwordVisibility = !passwordVisibility },
                        content = { Icon(imageVector = image, "") },
                    )

                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_lock_24),
                        contentDescription = "",
                    )
                },
                shape = CircleShape,
                colors = outlinedTextFieldColors(
                    focusedBorderColor = Blue,
                    focusedLabelColor = Blue,
                ),
            )
            Spacer(modifier = Modifier.height(30.dp))
            val buttonText = if(authType == AuthType.login) {
                stringResource(R.string.login)
            } else {
                stringResource(R.string.register)
            }

            MButton(
                modifier = Modifier
                    .width(230.dp)
                    .align(Alignment.CenterHorizontally),
                onClick = authenticate,
                text = buttonText,
            )
            Spacer(modifier = Modifier.height(50.dp))
        }

    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Login({ }, AuthType.register, mutableStateOf(""), mutableStateOf(""))
}
