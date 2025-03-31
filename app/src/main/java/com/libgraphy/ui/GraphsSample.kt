package com.libgraphy.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.library.libgraphy.ProgressBarChart
import com.library.libgraphy.data.ProgressBarChart
import com.library.libgraphy.data.TempDataSource


@Preview
@Composable
fun GraphSamples(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        SimpleProgressBarChar()


    }
}


@Composable
fun SimpleProgressBarChar(
    modifier: Modifier = Modifier
) {

    val data = ProgressBarChart(TempDataSource.chartItems)

    HeaderWrapper(header = "Simple Progress Bar Chart", modifier = modifier) {
        ProgressBarChart(progressBarChart = data)
    }
}


@Composable
fun HeaderWrapper(
    modifier: Modifier = Modifier,
    header: String,
    content: @Composable () -> Unit
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = header, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        content.invoke()
    }

}