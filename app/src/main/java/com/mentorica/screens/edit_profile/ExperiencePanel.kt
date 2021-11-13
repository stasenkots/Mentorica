package com.mentorica.screens.edit_profile

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mentorica.models.Experience
import com.mentorica.ui.components.Panel
import com.mentorica.ui.components.items.Experience
import java.time.LocalDate
import com.mentorica.R

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
                    from = LocalDate.now(),
                    to = LocalDate.now(),
                    position = "Senior Dev",
                ),
                Experience(
                    companyName = "Yandex",
                    from = LocalDate.now(),
                    to = LocalDate.now(),
                    position = "Dev Real",
                ),
            ),
        ),
    )
}
