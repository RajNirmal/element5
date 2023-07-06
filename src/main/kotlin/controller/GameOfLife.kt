package org.nirmal.controller

import org.nirmal.data.Seed
import org.nirmal.service.FileService
import org.nirmal.service.GameService

class GameOfLife {
    private val fileService = FileService()
    private val gameService = GameService()

    fun playGame(): Seed {
        val initialSeed = fileService.readFile()
        val nextSeed = gameService.generateNextSeed(initialSeed)
        nextSeed.printDeadOrAlive()
        return nextSeed
    }

}