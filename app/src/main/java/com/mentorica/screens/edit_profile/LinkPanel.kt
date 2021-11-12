package com.mentorica.screens.edit_profile

import android.annotation.SuppressLint
import android.view.View
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mentorica.R
import com.mentorica.models.Experience
import com.mentorica.models.Link
import com.mentorica.ui.components.Panel
import com.mentorica.ui.components.items.EditLinkItem
import java.time.LocalDate

@Composable
fun LinkPanel(
    modifier: Modifier = Modifier,
    linksState: MutableState<List<Link>>,
    removeLink: (Link) -> Unit,
) {
    Panel(
        modifier = modifier,
        titleId = R.string.links,
        itemsState = linksState,
    ) { links->
        Column(
            modifier = Modifier.padding(
                top = 60.dp,
                start = 30.dp,
                end = 30.dp,
                bottom = 20.dp,
            ),
        ) {
            for(link in links) {
                EditLinkItem(
                    modifier = Modifier
                        .padding(vertical = 5.dp),
                    link = link,
                    removeLink = removeLink,
                )
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun DefaultPreviewLinkPanel() {
    LinkPanel(
        removeLink = {},
        linksState = mutableStateOf(
            listOf(
                Link("Github", "https://github.com/stasenkots"),
                Link("Linkedin", "https://www.linkedin.com/in/stasenkots/"),
            ),
        ),
    )
}
