package com.mentorica.screens.edit_profile

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.text.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.mentorica.R
import com.mentorica.models.Experience
import com.mentorica.models.Link
import com.mentorica.models.Payment
import com.mentorica.models.Skill
import com.mentorica.models.User
import com.mentorica.models.UserState
import com.mentorica.ui.components.MentoricaImage
import com.mentorica.ui.components.button.MButton
import com.mentorica.ui.components.text.CheckBoxTextField
import com.mentorica.ui.components.text.MTextField
import com.mentorica.ui.theme.Blue
import com.mentorica.ui.theme.edit_screen_end
import com.mentorica.ui.theme.edit_screen_horizontal
import com.mentorica.ui.theme.edit_screen_vertical
import com.mentorica.utils.constants.ServerConstants
import java.time.LocalDate

@Composable
fun EditProfileScreen(viewModel: EditProfileViewModel = hiltViewModel()) {
    EditScreen(
        userState = viewModel.userState,
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
            modifier = Modifier.align(CenterHorizontally),
            text = stringResource(R.string.profile),
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
        )

        Spacer(Modifier.height(20.dp))
        Box(modifier = Modifier.align(CenterHorizontally)) {
            MentoricaImage(image = photo, width = 140.dp, height = 140.dp)
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
            modifier = textModifier,
            text = R.string.mentor,
            checkedState = userState.isMentor,
        )

        if (userState.isMentor.value) {
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
            skillsState = userState.skills,
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
            User(
                skills = listOf(Skill("asdqsd"), Skill("asdsd")),
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
                id = "dssa",
                isMentor = true,
                surname = "sdasd",
                name = "sdsad",
                education = emptyList(),
                photo = ServerConstants.DEFAULT_IMAGE_URL,
                description = "sadad",
                position = "sadad",
                company = "sdadasd",
                payment = Payment(10.0),
                favorites = emptyList()
            ),
        ),
        editErrorState = EditErrorState(),
        removeSkill = {},
        removeEducationExperience = {},
        removeWorkExperience = {},
        removeLink = {},
    )
}
