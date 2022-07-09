package com.mentorica.ui.components.text

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import com.mentorica.R
import com.mentorica.ui.theme.Blue
import com.mentorica.ui.theme.edit_screen_horizontal
import com.mentorica.ui.theme.edit_screen_vertical

@Composable
fun CheckBoxTextField(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    checkedState: MutableState<Boolean>,
) {
    var checked by remember { checkedState }
    Row(
        modifier
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = CircleShape
            ),
    ) {

        Image(
            painter = painterResource(R.drawable.blue_circle),
            contentDescription = null,
            modifier = Modifier.padding(
                top = 10.dp,
                start = 10.dp
            ),
        )
        Text(
            text = stringResource(text),
            fontSize = 18.sp,
            modifier = Modifier
                .fillMaxWidth(0.9F)
                .padding(top = 10.dp, start = 5.dp),
            color = Color.Gray,
        )
        Checkbox(
            modifier = Modifier.padding(end = 10.dp),
            checked = checked,
            onCheckedChange = { checked = it },
            colors = CheckboxDefaults.colors(checkedColor = Blue)
        )

    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    val textModifier = Modifier
        .fillMaxWidth()
        .padding(
            vertical = edit_screen_vertical,
            horizontal = edit_screen_horizontal,
        )

    CheckBoxTextField(
        textModifier,
        R.string.app_name,
        mutableStateOf(true),
    )
}
