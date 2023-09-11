package com.kodeco.android.coordplot

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun CustomSlider(modifier: Modifier = Modifier, value : Float =0.5f, changeValue : (Float) -> Unit={},text : String ="Axis"){
    Text(text = "${text}: ${(value*100).roundToInt()}",
        Modifier
            .padding(8.dp)
            .width(120.dp))
    Slider(
        value = value,
        valueRange = 0.01f..1f,
        onValueChange = changeValue


    )
}



