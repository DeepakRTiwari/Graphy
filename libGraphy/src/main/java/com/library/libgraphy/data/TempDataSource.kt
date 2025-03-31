package com.library.libgraphy.data

object TempDataSource {

    val chartItems = List(5) {
        ProgressBarChart.Item(
            score = (it / 100) * it,
            month = "Jan", // Increment month
            date = it.toString() // Increment date correctly
        )
    }

}