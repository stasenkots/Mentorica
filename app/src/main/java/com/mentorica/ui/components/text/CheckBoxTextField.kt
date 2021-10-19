package com.mentorica.ui.components.text

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mentorica.models.AuthType
import com.mentorica.screens.login.Login
import com.mentorica.R
import com.mentorica.ui.theme.Grey
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
                color = Grey,
                shape = CircleShape
            ),
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = 10.dp,
                vertical = 16.dp,
            ),
        ) {
            Image(
                painter = painterResource(R.drawable.blue_circle),
                contentDescription = null,
                modifier = Modifier.padding(),
            )
            Text(
                text = stringResource(text),
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth(0.9F)
                    .padding(horizontal = 5.dp),
                color = Color.Gray,
            )
            Checkbox(
                modifier = Modifier.fillMaxWidth(),
                checked = checked,
                onCheckedChange = { checked = it },
            )
        }
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
