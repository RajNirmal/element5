package org.nirmal.controller

import org.nirmal.service.FileService

class GameOfLife {
    val fileService = FileService()

    fun startGame(){
        val initialSeed = fileService.readFile()
//        val nextSeed = GameLogic.play()
    }

}