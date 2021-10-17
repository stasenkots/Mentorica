package com.mentorica.ui.components.text

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun ErrorText(text: String) {
    Text(
        text = text,
        fontSize = 13.sp,
        color = Color.Red,
        modifier = Modifier.padding(top = 5.dp, start = 20.dp),
    )
}
