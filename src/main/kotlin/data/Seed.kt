package org.nirmal.data

import com.google.gson.Gson

data class Seed(
    val cells: ArrayList<ArrayList<Int>>,
    val rowLength: Int = cells.size,
    val colLength: Int = cells[0].size
) {
    fun clone(): Seed {
        val gson = Gson()
        return gson.toJson(this).let { gson.fromJson(it, Seed::class.java) }
    }

    fun print() {
        cells.forEach { row ->
            row.forEach { column ->
                print(column)
            }
            println()

        }

    }

}
