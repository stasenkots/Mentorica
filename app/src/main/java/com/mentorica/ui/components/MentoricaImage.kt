package com.mentorica.ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.*
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun MentoricaImage(modifier: Modifier = Modifier, image: String, width: Dp, height: Dp) {
    val photoState by remember { mutableStateOf(image) }
    CoilImage(
        imageModel = photoState,
        modifier = modifier
            .border(0.dp, Color.Black, CircleShape)
            .width(width)
            .height(height)
            .clip(CircleShape),
        contentScale = ContentScale.Inside,
        shimmerParams = ShimmerParams(
            baseColor = MaterialTheme.colors.background,
            highlightColor = Color.White,
            durationMillis = 350,
            dropOff = 0.65f,
            tilt = 20f,
        ),
        failure = {
            Image(
                painter = painterResource(com.mentorica.R.drawable.no_image_icon),
                contentDescription = ""
            )
        },
    )
}
