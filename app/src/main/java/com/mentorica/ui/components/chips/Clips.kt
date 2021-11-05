package com.mentorica.ui.components.chips

import android.view.LayoutInflater
import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.mentorica.R
import com.mentorica.databinding.ChipBinding
import com.mentorica.databinding.ChipsBinding

@Composable
fun Chips(
    modifier: Modifier = Modifier,
    list: List<String>,
    removeItem: (View) -> Unit,
) {
    AndroidViewBinding(
        modifier = modifier,
        factory = ChipsBinding::inflate,
        update = {
            for(value in list) {
                val binding = ChipBinding.inflate(LayoutInflater.from(root.context))
                binding.chip.apply {
                    text = value
                    isCheckable = false
                    setOnCloseIconClickListener(removeItem)
                }
                root.addView(binding.chip)
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview1() {
    Chips(
        list = listOf("sda", "sdasdasd", "asdasdsad", "adsadsdasd", "asdsadasd", "sadasdsad"),
        removeItem = {},
    )
}

