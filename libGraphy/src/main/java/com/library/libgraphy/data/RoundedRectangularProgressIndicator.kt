package com.library.libgraphy.data

import androidx.annotation.FloatRange
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.library.libgraphy.theme.neonNazar
import com.library.libgraphy.theme.neonNazarA03
import com.library.libgraphy.theme.neonNazarA20

data class RoundedRectangularProgressIndicator(
    @FloatRange(from = 0.0, to = 1.0) val cornerRadius: Float = 0.5f,
    val strokeWidth: Dp = 4.dp,
    val trackColor: Color = neonNazarA20,
    val progressColor: Color = neonNazar,
    val contentInside: Content = Content()
) {
    data class Content(
        val color: Color = neonNazarA03,
        val padding: PaddingValues = PaddingValues(8.dp)
    )
}
