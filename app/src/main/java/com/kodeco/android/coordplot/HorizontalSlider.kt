package com.kodeco.android.coordplot

import androidx.compose.material.Slider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun createHorizontalSlider(modifier: Modifier = Modifier, value : Float =0.5f, changeValue : (Float) -> Unit){
    Slider(
        value = value,
        valueRange = 0.01f..1f,
        onValueChange = changeValue

    )
}