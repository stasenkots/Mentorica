package com.mentorica.ui.components.button

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mentorica.R
import com.mentorica.ui.theme.Blue


@Composable
fun MButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier.width(300.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Blue,
            contentColor = White
        ),
        onClick = onClick
    ) {
        Text(
            modifier = Modifier.padding(vertical = 7.dp),
            text = text,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MButton(onClick = { }, text = stringResource(R.string.app_name))
}

