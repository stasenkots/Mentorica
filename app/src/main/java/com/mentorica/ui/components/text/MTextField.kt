package com.mentorica.ui.components.text

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.text.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.*
import com.mentorica.ui.theme.Blue

@Composable
fun <T : String?> MTextField(
    textState: MutableState<T>,
    defaultValue: String = "",
    @StringRes hint: Int,
    errorState: MutableState<Int?>,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    var text by remember { textState }
    var error by remember { errorState }

    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = text ?: defaultValue,
        onValueChange = {
            text = it as T
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
    if (error != null) {
        val id = checkNotNull(error)
        ErrorText(text = stringResource(id = id))
    }
}
