package com.mentorica.ui.components.text

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.mentorica.R
import com.mentorica.ui.components.text.ErrorText
import com.mentorica.ui.theme.Blue
import java.lang.Error

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
    )
    if(error != null) {
        val id = checkNotNull(error)
        ErrorText(text = stringResource(id = id))
    }
}
