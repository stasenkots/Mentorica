package com.mentorica.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mentorica.R
import com.mentorica.models.Experience
import com.mentorica.ui.theme.poppins
import com.mentorica.ui.theme.poppinsBold
import com.mentorica.ui.theme.title
import com.mentorica.utils.formatToMonthYear
import java.time.LocalDate

@Composable
fun Experience(modifier: Modifier = Modifier, experience: Experience) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier
                .padding(8.dp),
            text = experience.companyName,
            fontSize = title,
            fontWeight = Bold,
            color = Color.DarkGray,
            textAlign = TextAlign.Center,
            fontFamily = poppinsBold
        )
        Row(modifier = Modifier.padding(bottom = 5.dp)) {
            Image(
                modifier = modifier.padding(end = 5.dp),
                painter = painterResource(R.drawable.ic_business),
                contentDescription = null,
            )
            val from = formatToMonthYear(experience.from)
            val to = formatToMonthYear(experience.to)

            Text(
                modifier = Modifier.align(Alignment.Bottom),
                text = "$from - $to",
                fontFamily = poppins
            )
        }
        Text(
            text = experience.position,
            fontFamily = poppins
        )

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Experience(
        experience = Experience(
            companyName = "Mentorica",
            from = LocalDate.now(),
            to = LocalDate.now(),
            position = "Senior Dev",
        ),
    )
}
