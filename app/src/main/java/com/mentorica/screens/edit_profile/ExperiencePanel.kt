package com.mentorica.screens.edit_profile

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import com.mentorica.R
import com.mentorica.models.Experience
import com.mentorica.ui.components.Panel
import com.mentorica.ui.components.items.Experience
import java.time.LocalDate

@Composable
fun ExperiencePanel(
    modifier: Modifier = Modifier,
    @StringRes titleId: Int,
    experiencesState: MutableState<List<Experience>>,
    removeExperience: (Experience) -> Unit,
) {

    Panel(
        modifier = modifier,
        titleId = titleId,
        itemsState = experiencesState,
    ) { experiences->
        LazyRow(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(
                    top = 80.dp,
                    bottom = 40.dp,
                    start = 20.dp,
                    end = 20.dp,
                ),
        ) {
            items(experiences) { experience->
                Experience(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    experience = experience,
                    removeExperience = removeExperience
                )
            }
        }

    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun DefaultPreviewExperiencePanel() {
    ExperiencePanel(
        removeExperience = {},
        titleId = R.string.skills,
        experiencesState = mutableStateOf(
            listOf(
                Experience(
                    companyName = "Mentorica",
                    startDate = LocalDate.now(),
                    endDate = LocalDate.now(),
                    position = "Senior Dev",
                ),
                Experience(
                    companyName = "Yandex",
                    startDate = LocalDate.now(),
                    endDate = LocalDate.now(),
                    position = "Dev Real",
                ),
            ),
        ),
    )
}
