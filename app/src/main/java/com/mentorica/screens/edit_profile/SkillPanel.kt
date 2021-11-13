package com.mentorica.screens.edit_profile

import android.annotation.SuppressLint
import android.view.View
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mentorica.R
import com.mentorica.models.Skill
import com.mentorica.ui.components.Panel
import com.mentorica.ui.components.chips.Chips

@Composable
fun SkillPanel(
    modifier: Modifier = Modifier,
    skillsState: MutableState<List<Skill>>,
    removeSkill: (Skill) -> Unit,
) {

    val removeItem = { s: String->
        removeSkill(Skill(s))
    }

    Panel(
        modifier = modifier,
        titleId = R.string.skills,
        itemsState = skillsState,
    ) { skills->
        Chips(
            modifier = Modifier.padding(
                top = 60.dp,
                start = 20.dp,
                end = 20.dp,
                bottom = 20.dp,
            ),
            list = skills
                .map { it.skill },
            removeItem = removeItem,
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun DefaultPreviewSkillPanel() {
    SkillPanel(
        skillsState = mutableStateOf(
            listOf(),
        ),
        removeSkill = {},
    )
}

