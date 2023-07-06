package controller

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockkConstructor
import io.mockk.verify
import org.junit.jupiter.api.assertThrows
import org.nirmal.controller.GameOfLife
import org.nirmal.data.Seed
import org.nirmal.service.FileService
import org.nirmal.service.GameService

class GameOfLifeTest : DescribeSpec({


    val sampleInputSeed = Seed(
        arrayListOf(
            arrayListOf(1, 1),
            arrayListOf(1, 1)
        )
    )

    val sampleOutputSeed = Seed(
        arrayListOf(
            arrayListOf(1, 1, 1),
            arrayListOf(1, 1, 1)
        )
    )
    describe("startGame") {
        beforeEach {
            mockkConstructor(FileService::class)
            mockkConstructor(GameService::class)
            every { anyConstructed<FileService>().readFile(any()) } returns sampleInputSeed

            every { anyConstructed<GameService>().generateNextSeed(any()) } returns sampleOutputSeed
        }

        it("should invoke fileservice and gameService") {
            val gameOfLife = GameOfLife()
            val output = gameOfLife.playGame()

            verify(exactly = 1) { anyConstructed<FileService>().readFile() }
            verify(exactly = 1) { anyConstructed<GameService>().generateNextSeed(sampleInputSeed) }
            output shouldBe sampleOutputSeed
        }

        it("should throw exception when fileservice throws exception") {
            every { anyConstructed<FileService>().readFile(any()) } throws Exception("Random exception")

            val gameOfLife = GameOfLife()
            assertThrows<Exception> { gameOfLife.playGame() }

            verify(exactly = 1) { anyConstructed<FileService>().readFile() }
            verify(exactly = 0) { anyConstructed<GameService>().generateNextSeed(sampleInputSeed) }

        }

    }
})