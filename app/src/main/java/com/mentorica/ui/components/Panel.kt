package com.mentorica.ui.components

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mentorica.R
import com.mentorica.screens.edit_profile.SkillPanel
import com.mentorica.ui.theme.LightTransparentGray
import com.mentorica.ui.theme.poppins
import com.mentorica.ui.theme.poppinsBold
import com.mentorica.ui.theme.title

@Composable
fun <T> Panel(
    modifier: Modifier = Modifier,
    @StringRes titleId: Int,
    itemsState: MutableState<List<T>>,
    content: @Composable BoxScope.(List<T>) -> Unit,
) {

    val items by remember { itemsState }
    val boxShape = RoundedCornerShape(15)
    Box(
        modifier = modifier
            .clip(boxShape)
            .background(LightTransparentGray)
            .border(2.dp, Color.Gray, boxShape),
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 20.dp)
                .fillMaxWidth(),
            text = stringResource(titleId),
            fontSize = title,
            color = Color.DarkGray,
            fontFamily = poppinsBold
        )
        Image(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(horizontal = 30.dp, vertical = 20.dp),
            painter = painterResource(R.drawable.ic_add_circle_outline),
            contentDescription = null,
        )

        content(items)
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun DefaultPreviewExperiencePanel() {
    SkillPanel(
        skillsState = mutableStateOf(
            listOf(
                "asas", "asasas",
                "sasddd", "addddd", "adasdasd", "assdsasdsad",
            ),
        ),
    )
}
