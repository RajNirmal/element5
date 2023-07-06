package org.nirmal

import org.nirmal.controller.GameOfLife


fun main(args: Array<String>) {
    val gameOfLife = GameOfLife()
    try {
        gameOfLife.playGame()
    } catch (exp: Exception) {
        println("Exception occured while running the code ")
        println(exp)
    }
}


