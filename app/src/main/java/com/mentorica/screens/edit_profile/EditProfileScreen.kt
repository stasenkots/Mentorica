package com.mentorica.screens.edit_profile

import android.annotation.SuppressLint
import android.view.View
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.hilt.navigation.compose.hiltViewModel
import com.mentorica.R
import com.mentorica.models.*
import com.mentorica.ui.components.button.MButton
import com.mentorica.ui.components.text.CheckBoxTextField
import com.mentorica.ui.components.text.MTextField
import com.mentorica.ui.theme.*
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage
import java.time.LocalDate

@Composable
fun EditProfileScreen(viewModel: EditProfileViewModel = hiltViewModel()) {
    EditScreen(
        userState = viewModel.user,
        editErrorState = viewModel.editErrorState,
        save = viewModel::saveUserData,
        removeSkill = viewModel::removeSkill,
        removeWorkExperience = viewModel::removeWorkExperience,
        removeEducationExperience = viewModel::removeEducationExperience,
        removeLink = viewModel::removeLink,
    )
}

@Composable
fun EditScreen(
    userState: UserState,
    editErrorState: EditErrorState,
    save: () -> Unit,
    removeSkill: (Skill) -> Unit,
    removeWorkExperience: (Experience) -> Unit,
    removeEducationExperience: (Experience) -> Unit,
    removeLink: (Link) -> Unit,
) {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .background(Blue)
            .verticalScroll(scrollState),
    ) {
        EditProfileTopBar(
            photoState = userState.photo,
        )
        EditProfileBody(
            userState = userState,
            editErrorState = editErrorState,
            save = save,
            removeSkill = removeSkill,
            removeEducationExperience = removeEducationExperience,
            removeWorkExperience = removeWorkExperience,
            removeLink = removeLink,
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
    save: () -> Unit,
    removeSkill: (Skill) -> Unit,
    removeWorkExperience: (Experience) -> Unit,
    removeEducationExperience: (Experience) -> Unit,
    removeLink: (Link) -> Unit,
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

        CheckBoxTextField(
            modifier = textModifier
                .padding(vertical = edit_screen_vertical),
            text = R.string.mentor,
            checkedState = userState.isMentor,
        )

        if(userState.isMentor.value) {
            MTextField(
                textState = userState.payment,
                hint = R.string.payment,
                errorState = editErrorState.payment,
                modifier = textModifier,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                ),
            )
        }
        SkillPanel(
            modifier = Modifier.padding(
                horizontal = edit_screen_horizontal,
                vertical = edit_screen_vertical,

                ),
            skillsState = userState.technologies,
            removeSkill = removeSkill,
        )

        ExperiencePanel(
            modifier = Modifier.padding(
                horizontal = edit_screen_horizontal,
                vertical = edit_screen_vertical,
            ),
            titleId = R.string.work_experience,
            experiencesState = userState.workExperience,
            removeExperience = removeWorkExperience,
        )

        ExperiencePanel(
            modifier = Modifier.padding(
                horizontal = edit_screen_horizontal,
                vertical = edit_screen_vertical,
            ),
            titleId = R.string.education,
            experiencesState = userState.education,
            removeExperience = removeEducationExperience,
        )
        LinkPanel(
            modifier = Modifier.padding(
                horizontal = edit_screen_horizontal,
                vertical = edit_screen_vertical,
            ),
            linksState = userState.links,
            removeLink = removeLink,
        )
        MButton(
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(
                    top = 50.dp,
                    bottom = 40.dp,
                ),
            text = stringResource(R.string.save),
            onClick = save,
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EditScreen(
        save = { },
        userState = UserState(
            technologies = listOf("asdqsd", "asdsd", "adsdasd"),
            workExperience = listOf(
                Experience(
                    "Mentorica",
                    LocalDate.now(), LocalDate.now(), "Senior dev",
                ),
                Experience(
                    "Facebook",
                    LocalDate.now(), LocalDate.now(), "Senior dev",
                ),
                Experience(
                    "Yandex",
                    LocalDate.now(), LocalDate.now(), "Senior dev",
                ),
            ),
            links = listOf(
                Link("Github", "https://github.com/stasenkots"),
                Link("Linkedin", "https://www.linkedin.com/in/stasenkots/"),
            ),
        ),
        editErrorState = EditErrorState(),
        removeSkill = {},
        removeEducationExperience = {},
        removeWorkExperience = {},
        removeLink = {},
    )
}
