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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme

@Composable
fun PlotSurface() {
    var xPercent: Float by rememberSaveable { mutableStateOf(0.5f) }
    var yPercent: Float by rememberSaveable { mutableStateOf(0.5f) }
    var isPortrait =true
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        val configuration= LocalConfiguration.current
        val orientation=configuration.orientation
        when(orientation){
            Configuration.ORIENTATION_PORTRAIT-> isPortrait=true
            Configuration.ORIENTATION_LANDSCAPE->isPortrait=false
        }
        if(isPortrait) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    Modifier
                        .background(Color.Blue)
                        .size(300.dp)
                ) {
                    Map(xPercent, yPercent)
                }
                Row(Modifier.padding(16.dp)){

                    CustomSlider(value = xPercent,
                        changeValue = { value ->
                            xPercent = value
                        }, text = "X-Axis"
                    )
                }

                Row(Modifier.padding(16.dp)){
                    CustomSlider(value = yPercent,
                        changeValue = { value ->
                            yPercent = value
                        }, text = "Y-Axis"
                    )
                }

            }
        }else if(!isPortrait){
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,

                ){
                Box(
                    Modifier
                        .padding(12.dp)
                        .background(Color.Blue)
                        .size(300.dp)


                ){
                    Map(xPercent, yPercent)
                }
                Column(Modifier.padding(16.dp)) {

                    CustomSlider(
                        value = xPercent,
                        changeValue = { value ->
                            xPercent = value
                        }, text = "X-Axis"
                    )
                    CustomSlider(
                        value = yPercent,
                        changeValue = { value ->
                            yPercent = value
                        }, text = "Y-Axis"
                    )
                }

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
