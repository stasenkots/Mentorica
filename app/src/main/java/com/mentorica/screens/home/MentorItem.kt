package com.mentorica.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mentorica.R
import com.mentorica.models.currentUser
import com.mentorica.models.setCurrentUser
import com.mentorica.ui.theme.BlueOpacityDark
import com.mentorica.ui.theme.DarkBlueText
import com.mentorica.utils.getPaymentFormat

@ExperimentalMaterialApi
@Composable
fun MentorItem(
    user: User,
    onClick: () -> Unit,
    addToFavorites: (String) -> Unit,
    removeToFavorites: (String) -> Unit,
) {
    val fullName = "${user.name} ${user.surname}"
    val status = stringResource(R.string.user_status, user.position, user.company)
    val payment = if(user.payment != null)
        stringResource(R.string.user_payment, getPaymentFormat(user.payment)) else null
    var isFavorite by remember { mutableStateOf(currentUser.favorites.contains(user.id)) }
    Card(onClick = onClick) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(color = BlueOpacity)
                .border(
                    width = 0.1.dp,
                    color = BlueOpacity,
                    shape = RoundedCornerShape(15.dp),
                ),
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
                if(payment != null) {
                    Text(
                        modifier = Modifier.padding(vertical = 8.dp),
                        text = payment,
                        fontWeight = FontWeight.SemiBold,
                        color = DarkBlueText,
                        fontSize = 16.sp,
                    )
                }
            }
            Spacer(modifier = Modifier.width(32.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterVertically),
            ) {
                val onClickFavorite = {
                    if(isFavorite) removeToFavorites(user.id)
                    else addToFavorites(user.id)
                    isFavorite = !isFavorite
                }
                IconButton(
                    modifier = Modifier.size(64.dp),
                    onClick = onClickFavorite,
                ) {
                    val iconFavoriteId = if(isFavorite) R.drawable.ic_favorite_filled
                    else R.drawable.ic_favorite_empty
                    Icon(
                        modifier = Modifier.size(64.dp),
                        painter = painterResource(iconFavoriteId),
                        contentDescription = null,
                        tint = BlueOpacityDark,
                    )
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val user = User(
        "qwerty123456",
        "https://thispersondoesnotexist.com/image", "John",
        "Doe", "freak", "Senior Dev", "Oracle", true,
        10.0, arrayOf("JS", "Kotlin"), emptyArray(), arrayOf("BSU"), emptyArray(), emptyList(),
    )
    setCurrentUser(
        "qwerty123456",
        "https://thispersondoesnotexist.com/image", "John",
        "Doe", "freak", "Senior Dev", "Oracle", true,
        10.0, arrayOf("JS", "Kotlin"), emptyArray(), arrayOf("BSU"), emptyArray(), emptyList(),
    )
    MentorItem(user, onClick = {}, {}, {})
}
