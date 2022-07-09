package com.mentorica.ui.components.items

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mentorica.R
import com.mentorica.models.Experience
import com.mentorica.ui.theme.LightTransparentGray
import com.mentorica.ui.theme.poppins
import com.mentorica.ui.theme.poppinsBold
import com.mentorica.ui.theme.title
import com.mentorica.utils.formatToMonthYear
import java.time.LocalDate

@Composable
fun Experience(
    modifier: Modifier = Modifier,
    experience: Experience,
    removeExperience: (Experience) -> Unit,
) {

    val boxShape = RoundedCornerShape(20)
    Box(
        modifier = modifier
            .clip(boxShape)
            .background(LightTransparentGray)
            .border(2.dp, Color.Gray, boxShape)
            .padding(10.dp),
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable(onClick = { removeExperience(experience) }),
                painter = painterResource(R.drawable.ic_delete),
                contentDescription = null,
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 10.dp),
                text = experience.companyName,
                fontSize = title,
                fontWeight = Bold,
                color = Color.DarkGray,
                textAlign = TextAlign.Center,
                fontFamily = poppinsBold,
            )
            Row(
                modifier = Modifier.padding(
                    bottom = 5.dp,
                    start = 10.dp,
                    end = 10.dp,
                ),
            ) {
                Image(
                    modifier = modifier.padding(end = 5.dp),
                    painter = painterResource(R.drawable.ic_business),
                    contentDescription = null,
                )
                val from = formatToMonthYear(experience.startDate)
                val to = formatToMonthYear(experience.endDate)

                Text(
                    modifier = Modifier.align(Alignment.Bottom),
                    text = "$from - $to",
                    fontFamily = poppins,
                )
            }
            Text(
                modifier = Modifier.padding(horizontal = 5.dp),
                text = experience.position,
                fontFamily = poppins,
            )

        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Experience(
        removeExperience = {},
        experience = Experience(
            companyName = "Mentorica",
            startDate = LocalDate.now(),
            endDate = LocalDate.now(),
            position = "Senior Pomidor Developer",
        ),
    )
}
