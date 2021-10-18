package com.mentorica.screens.edit_profile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mentorica.R
import com.mentorica.models.UserState
import com.mentorica.ui.components.text.MTextField
import com.mentorica.ui.theme.*
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun EditProfileScreen(viewModel: EditProfileViewModel = hiltViewModel()) {
    EditScreen(
        viewModel::saveUserData,
        viewModel.user,
        viewModel.editErrorState,
    )
}

@Composable
fun EditScreen(
    save: () -> Unit,
    userState: UserState,
    editErrorState: EditErrorState,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .background(Blue)
            .scrollable(
                state = scrollState,
                orientation = Orientation.Vertical,
            ),
    ) {
        EditProfileTopBar(
            photoState = userState.photo
        )
        EditProfileBody(
            userState = userState,
            editErrorState = editErrorState
        )

    }
}

@Composable
fun EditProfileTopBar(
    photoState: MutableState<String>,
) {
    val photo by remember { photoState }

    Column(
        modifier = Modifier
            .fillMaxWidth(),

        ) {
        Spacer(Modifier.height(20.dp))
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = stringResource(R.string.profile),
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
        )

        Spacer(Modifier.height(20.dp))
        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {

            CoilImage(
                imageModel = photo,
                modifier = Modifier
                    .border(0.dp, Color.Black, CircleShape)
                    .width(140.dp)
                    .height(140.dp),
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
            Image(
                painter = painterResource(R.drawable.edit),
                contentDescription = "",
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
                    .align(Alignment.BottomEnd),
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

    }
}

@Composable
fun EditProfileBody(
    userState: UserState,
    editErrorState: EditErrorState,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .clip(RoundedCornerShape(8))
            .background(Color.White)
            .padding(
                top = edit_screen_vertical,
                start = edit_screen_horizontal,
                end = edit_screen_end,
            ),
    ) {
        Spacer(Modifier.height(30.dp))

        val textModifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = edit_screen_vertical,
                horizontal = edit_screen_horizontal,
            )

        MTextField(
            textState = userState.name,
            hint = R.string.name,
            errorState = editErrorState.name,
            modifier = textModifier,
        )

        MTextField(
            textState = userState.surname,
            hint = R.string.surname,
            errorState = editErrorState.surname,
            modifier = textModifier,
        )

        MTextField(
            textState = userState.description,
            hint = R.string.description,
            errorState = editErrorState.description,
            modifier = textModifier,
        )

        MTextField(
            textState = userState.position,
            hint = R.string.position,
            errorState = editErrorState.position,
            modifier = textModifier,
        )

        MTextField(
            textState = userState.company,
            hint = R.string.company,
            errorState = editErrorState.company,
            modifier = textModifier,
        )

    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EditScreen(
        { },
        UserState(),
        EditErrorState(),
    )
}
