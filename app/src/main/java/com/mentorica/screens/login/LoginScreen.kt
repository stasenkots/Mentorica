package com.mentorica.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
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
import com.mentorica.ui.theme.poppins

@Composable
fun LoginScreen(authType: AuthType, viewModel: LoginViewModel = hiltViewModel()) {
    Login(viewModel::authenticate, authType)
}

@Composable
fun Login(authenticate: (String, String) -> Unit, authType: AuthType) {

    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
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
                value = login,
                onValueChange = { login = it },
                label = { Text(text = stringResource(R.string.login)) },
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_outline_person_24),
                        contentDescription = "",
                    )
                },
                shape = CircleShape,
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
            )
            Spacer(modifier = Modifier.height(30.dp))
            val buttonText = if (authType == AuthType.login){
                stringResource(R.string.login)
            } else{
                stringResource(R.string.register)
            }

            MButton(
                modifier = Modifier
                    .width(230.dp)
                    .align(Alignment.CenterHorizontally),
                onClick = { authenticate(login, password) },
                text = buttonText,
            )
            Spacer(modifier = Modifier.height(50.dp))
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Login({ _, _-> }, AuthType.register)
}
