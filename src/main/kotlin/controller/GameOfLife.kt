package org.nirmal.controller

import org.nirmal.service.FileService
import org.nirmal.service.GameService

class GameOfLife {
    val fileService = FileService()
    val gameService = GameService()

    fun startGame(){
        val initialSeed = fileService.readFile()
        val nextSeed = gameService.generateNextSeed(initialSeed)
        nextSeed.printDeadOrAlive()
    }

}