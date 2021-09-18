package com.mentorica.ui.get_started

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mentorica.R
import com.mentorica.ui.components.MButton
import com.mentorica.ui.theme.DarkBlue
import com.mentorica.ui.theme.Orange

@Composable
fun GetStartedScreen(viewModel: GetStartedViewModel = hiltViewModel()) {
    GetStarted(
        viewModel::login,
        viewModel::register
    )
}

@Composable
fun GetStarted(
    onLoginClicked: () -> Unit,
    onRegisterClicked: () -> Unit
) {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        painter = painterResource(R.drawable.get_started),
        contentDescription = "",
        alignment = Alignment.TopCenter,
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val content = buildAnnotatedString {
            append(stringResource(R.string.we_can) + " ")
            withStyle(style = SpanStyle(color = Orange)) {
                append(stringResource(R.string.help_you) + " ")
            }
            append(stringResource(R.string.to_be_a_better_version) + " ")
            withStyle(style = SpanStyle(color = Orange)) {
                append(stringResource(R.string.yourself))
            }
        }.toUpperCase()
        Text(
            modifier = Modifier.padding(
                start = 55.dp,
                end = 55.dp,
                bottom = 30.dp,
                top = 20.dp
            ),
            text = content,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            color = DarkBlue,
            letterSpacing = 1.sp
        )

        MButton(onClick = onLoginClicked, stringId = R.string.login)
        Spacer(modifier = Modifier.height(10.dp))
        MButton(onClick = onRegisterClicked, stringId = R.string.register)

        Spacer(modifier = Modifier.height(100.dp))

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GetStarted({},{})
}

