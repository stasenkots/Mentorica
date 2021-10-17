package com.mentorica.ui.components.text

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.mentorica.R
import com.mentorica.ui.theme.Blue

@Composable
fun PasswordText(
    passwordState: MutableState<String>,
    errorState: MutableState<String?>,
) {

    var password by remember { passwordState }
    var passwordVisibility by remember { mutableStateOf(false) }
    val error by remember { errorState }

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
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Blue,
            focusedLabelColor = Blue,
        ),
        isError = error != null,
        visualTransformation = if(passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
    )
    if(error != null) {
        ErrorText(text = checkNotNull(error))
    }
}
