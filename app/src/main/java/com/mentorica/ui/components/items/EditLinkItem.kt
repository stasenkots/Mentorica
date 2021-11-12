package com.mentorica.ui.components.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mentorica.R
import com.mentorica.models.Link
import java.time.LocalDate

@Composable
fun EditLinkItem(
    modifier: Modifier = Modifier,
    link: Link,
    removeLink: (Link) -> Unit,
) {
    Box(
        modifier
            .fillMaxWidth(),
    ) {
        Column {
            Text("${link.site}:")
            Text(
                text = link.link,
                style = TextStyle(textDecoration = TextDecoration.Underline),
            )
        }
        Image(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .clickable {
                    removeLink(link)
                },
            painter = painterResource(R.drawable.ic_delete),
            contentDescription = null,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewEditLinkItem() {
    EditLinkItem(
        link = Link("Github", "https://github.com/stasenkots"),
        removeLink = {},
    )
}
