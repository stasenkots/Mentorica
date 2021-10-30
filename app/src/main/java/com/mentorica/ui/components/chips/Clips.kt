package com.mentorica.ui.components.chips

import android.view.LayoutInflater
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.mentorica.databinding.ChipBinding
import com.mentorica.databinding.ChipsBinding

@Composable
fun Chips(list: List<String>) {
    AndroidViewBinding(
        factory = ChipsBinding::inflate,
        update = {
            for(value in list) {
                val chip = ChipBinding.inflate(LayoutInflater.from(root.context))
                chip.chip.text = value
                root.addView(chip.chip)
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview1() {
    Chips(listOf("sda", "sdasdasd", "asdasdsad", "adsadsdasd", "asdsadasd", "sadasdsad"))
}

