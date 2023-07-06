package org.nirmal.service

import org.nirmal.data.Seed

class GameService {
    private lateinit var generatedSeed: Seed
    private lateinit var initialSeed: Seed
    fun generateNextSeed(initialSeed: Seed): Seed {
        generatedSeed = initialSeed.copy()
        this.initialSeed = initialSeed

        return initialSeed
    }


     fun aliveNeighboursCount(rowIndex: Int, colIndex: Int): Int {
        var neighbourCount = 0
        val left: Int = colIndex - 1
        val up: Int = rowIndex - 1
        val right: Int = colIndex + 1
        val down: Int = rowIndex + 1

         if (right < initialSeed.colLength) { //will check the three right neighbors
             neighbourCount += initialSeed.cells[rowIndex][right]
             if (up >= 0) {
                 neighbourCount += initialSeed.cells[up][right]
             }
             if (down < initialSeed.rowLength) {
                 neighbourCount += initialSeed.cells[down][right]
             }
         }
         if (left >= 0) {
             neighbourCount += initialSeed.cells[rowIndex][left]
             if (up >= 0) {
                 neighbourCount += initialSeed.cells[up][left]
             }
             if (down < initialSeed.rowLength) {
                 neighbourCount += initialSeed.cells[down][left]
             }
         }

        if (up >= 0) {
            //Neighbour count of cells above
            neighbourCount += initialSeed.cells[up][colIndex]
        }
        if (down < initialSeed.rowLength) {
            //Neighbour count of cells below
            neighbourCount += initialSeed.cells[down][colIndex]
        }

        return neighbourCount
    }


}

object CellStatus {
    const val ALIVE = 1
    const val DEAD = 0
}