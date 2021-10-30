package com.mentorica.ui.components.text

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.mentorica.ui.theme.Blue

@Composable
fun MTextField(
    textState: MutableState<String>,
    @StringRes hint: Int,
    errorState: MutableState<Int?>,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    var text by remember { textState }
    var error by remember { errorState }

    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = text,
        onValueChange = {
            text = it
            error = null
        },
        label = { Text(text = stringResource(hint)) },
        shape = CircleShape,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Blue,
            focusedLabelColor = Blue,
        ),
        isError = error != null,
        keyboardOptions = keyboardOptions
    )
    if(error != null) {
        val id = checkNotNull(error)
        ErrorText(text = stringResource(id = id))
    }
}
