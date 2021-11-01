package com.mentorica.screens.edit_profile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mentorica.R
import com.mentorica.ui.components.chips.Chips
import com.mentorica.ui.theme.LightTransparentGray
import com.mentorica.ui.theme.title

@Composable
fun SkillPanel(
    modifier: Modifier = Modifier,
    skillsState: MutableState<List<String>>,
) {

    val skills by remember { skillsState }
    val boxShape = RoundedCornerShape(20)
    Box(
        modifier = modifier
            .clip(boxShape)
            .background(LightTransparentGray)
            .border(2.dp, Color.Gray, boxShape),
    ) {
        Text(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            text = stringResource(R.string.skills),
            fontSize = title,
            color = Color.DarkGray,
        )
        Image(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(20.dp),
            painter = painterResource(R.drawable.ic_add_circle_outline),
            contentDescription = null,
        )
        Chips(
            modifier = Modifier.padding(
                top = 60.dp,
                start = 20.dp,
                end = 20.dp,
                bottom = 20.dp,
            ),
            skills = skills,
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    SkillPanel(
        skillsState = mutableStateOf(
            listOf(
                "asas", "asasas",
                "sasddd", "addddd", "adasdasd", "assdsasdsad",
            ),
        ),
    )
}

