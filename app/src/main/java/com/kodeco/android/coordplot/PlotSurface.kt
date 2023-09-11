package com.kodeco.android.coordplot

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme

@Composable
fun PlotSurface() {
    var xPercent: Float by rememberSaveable { mutableStateOf(0.5f) }
    var yPercent: Float by rememberSaveable { mutableStateOf(0.5f) }
    var height= 300
    val configuration = LocalConfiguration.current
    when(configuration.orientation){
        Configuration.ORIENTATION_LANDSCAPE -> height=200
        Configuration.ORIENTATION_PORTRAIT -> height=300
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            Box(
                Modifier
                    .background(Color.Blue)
                    .size(height.dp)){
                Map(xPercent,yPercent,height)
            }

            Row (Modifier.padding(16.dp)){

                CustomSlider(value = xPercent,
                    changeValue = { value ->
                        xPercent = value
                    },text= stringResource(R.string.x_axis)
                )
            }
            Row (Modifier.padding(16.dp)){

                CustomSlider(value = yPercent,
                    changeValue = { value ->
                        yPercent = value
                    },text= stringResource(R.string.y_axis)
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PlotSurfacePreview() {
    MyApplicationTheme {
        PlotSurface()
    }
}
