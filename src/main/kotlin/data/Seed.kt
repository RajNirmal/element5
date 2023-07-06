package org.nirmal.data

data class Seed(
    val cells: ArrayList<ArrayList<Int>>,
    val rowLength: Int = cells.size,
    val colLength: Int = cells[0].size
)
