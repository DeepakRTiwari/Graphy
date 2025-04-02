package com.libgraphy.ui

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.library.libgraphy.ProgressBarChart
import com.library.libgraphy.ProgressBarChartWithTextIndicator
import com.library.libgraphy.RoundedRectangularProgressIndicator
import com.library.libgraphy.data.ProgressBarChart
import com.library.libgraphy.data.RoundedRectangularProgressIndicator
import com.library.libgraphy.data.TempDataSource
import kotlinx.coroutines.delay
import kotlin.text.Typography.bullet


@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun GraphSamples(
    modifier: Modifier = Modifier
) {

    val graphModifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .height(250.dp)

    val progressBarChartData = ProgressBarChart(
        item = TempDataSource.chartItems, // Sample data
        dateStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = Color.White
        ),
        monthStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            color = Color.White
        ),
        scoreStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            color = Color.White
        ),
        barWidth = 16.dp,
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(18.dp),
    ) {

        SimpleProgressBarChar(
            data = progressBarChartData,
            modifier = graphModifier
        )

        RoundedCornerProgressIndicator(
            modifier = graphModifier
        )

        TextIndicatorBarChart(
            data = progressBarChartData,
            modifier = graphModifier
        )

    }
}


@Composable
fun SimpleProgressBarChar(
    modifier: Modifier = Modifier,
    data: ProgressBarChart
) {
    HeaderWrapper(header = "Simple Progress Bar Chart", modifier = Modifier) {
        ProgressBarChart(
            progressBarChart = data,
            modifier = modifier
        )
    }
}


@Composable
private fun TextIndicatorBarChart(
    modifier: Modifier = Modifier,
    data: ProgressBarChart
) {
    HeaderWrapper(header = "Progress BarChart With TextIndicator", modifier = Modifier) {

        ProgressBarChartWithTextIndicator(
            progressBarChart = data,
            modifier = modifier
        )
    }
}

@Composable
private fun RoundedCornerProgressIndicator(
    modifier: Modifier = Modifier,
) {
    HeaderWrapper(header = "Rounded Rectangular Progress Indicator", modifier = Modifier) {

        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center
        ) {
            var progress by remember { mutableFloatStateOf(0.1f) }

            val animatedProgress = animateFloatAsState(
                targetValue = progress,
                animationSpec = tween(5000, 1000, FastOutSlowInEasing),
                label = "progress"
            )

            RoundedRectangularProgressIndicator(
                progress = { animatedProgress.value },
                roundedRectangularProgressIndicator = RoundedRectangularProgressIndicator(),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp)
            ) {
                Text("Your Content Here!", color = Color.White)
            }

            LaunchedEffect(Unit) {
                while (progress < 0.5f) {
                    progress += 0.01f // Increment progress in steps
                    delay(50L) // Delay for smooth animation
                }
            }
        }
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
        Text(
            text = " $bullet  ${header.uppercase()}",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        content.invoke()
    }

}