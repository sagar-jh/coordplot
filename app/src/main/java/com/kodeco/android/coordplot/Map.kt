package com.kodeco.android.coordplot

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme

@Composable
fun Map(xPercent: Float, yPercent: Float, modifier: Modifier = Modifier) {

    Image(painter = painterResource(id = R.drawable.star), contentDescription = stringResource(R.string.star_image),
        Modifier
            .size(36.dp)
            .offset(((xPercent * 300 - 18).dp).coerceIn(0.dp, 300.dp - 36.dp), ((yPercent * 300 - 18).dp).coerceIn(0.dp, 300.dp - 36.dp))
    )
}

@Preview(showBackground = true)
@Composable
fun MapPreview() {
    MyApplicationTheme {
        Map(xPercent = 0.5f, yPercent = 0.5f)
    }
}
