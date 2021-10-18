package com.mentorica.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mentorica.models.User
import com.mentorica.services.UserLogin.photo
import com.mentorica.ui.theme.BlueOpacity
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mentorica.R
import com.mentorica.ui.theme.DarkBlueText

@ExperimentalMaterialApi
@Composable
fun MentorItem(user: User, onClick: () -> Unit, addToFavorites: () -> Unit) {
    val fullName = "${user.name} ${user.surname}"
    val status = "${user.position} in ${user.company}"
    val payment = if(user.payment!! - user.payment.toInt() == 0.0) "${user.payment.toInt()}\$p/h"
    else "${user.payment}\$p/h"
    Card(onClick = onClick) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(color = BlueOpacity)
                .border(width = 0.1.dp, color = BlueOpacity, shape = RoundedCornerShape(15.dp)),
        ) {
            Spacer(modifier = Modifier.width(15.dp))
            CoilImage(
                imageModel = photo,
                modifier = Modifier
                    .border(0.dp, Color.Black, CircleShape)
                    .width(100.dp)
                    .height(100.dp)
                    .align(Alignment.CenterVertically),
                shimmerParams = ShimmerParams(
                    baseColor = MaterialTheme.colors.background,
                    highlightColor = Color.White,
                    durationMillis = 350,
                    dropOff = 0.65f,
                    tilt = 20f,
                ),
                failure = {
                    Text(text = stringResource(R.string.failed_to_load_image))
                },
            )
            Spacer(modifier = Modifier.width(40.dp))
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
            ) {
                Text(
                    text = fullName,
                    fontWeight = FontWeight.SemiBold,
                    color = DarkBlueText,
                    fontSize = 16.sp,
                )
                Text(
                    text = status,
                    fontWeight = FontWeight.Light,
                    color = DarkBlueText,
                    fontSize = 12.sp,
                )
                Text(
                    modifier = Modifier.padding(vertical = 8.dp),
                    text = payment,
                    fontWeight = FontWeight.SemiBold,
                    color = DarkBlueText,
                    fontSize = 16.sp,
                )
            }
            Column() {

            }
        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val user = User(
        "https://thispersondoesnotexist.com/image", "John",
        "Doe", "freak", "Senior Dev", "Oracle", true,
        10.0, arrayOf("JS", "Kotlin"), emptyArray(), arrayOf("BSU"), emptyArray(),
    )
    MentorItem(user, onClick = {}, {})
}
