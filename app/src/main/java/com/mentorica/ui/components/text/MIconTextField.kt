package com.mentorica.ui.components.text

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.*
import com.mentorica.ui.theme.Blue

@Composable
fun MIconTextField(
    textState: MutableState<String>,
    @DrawableRes icon: Int,
    @StringRes hint: Int,
    errorState: MutableState<Int?>,
    modifier: Modifier = Modifier,
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
        leadingIcon = {
            Icon(
                painter = painterResource(icon),
                contentDescription = "",
            )

        },
        shape = CircleShape,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Blue,
            focusedLabelColor = Blue,
        ),
        isError = error != null,
        maxLines = 1
    )
    if(error != null) {
        val id = checkNotNull(error)
        ErrorText(text = stringResource(id = id))
    }
}
