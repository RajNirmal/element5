package service

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.nirmal.data.Seed
import org.nirmal.service.GameService

class GameServiceTest : DescribeSpec({
    val gameService = GameService()
    describe("generateNextSeed") {
        mapOf(
            Seed(
                arrayListOf(
                    arrayListOf(1, 1, 0),
                    arrayListOf(1, 0, 1),
                    arrayListOf(0, 1, 0)
                )
            ) to
                    Seed(
                        arrayListOf(
                            arrayListOf(1, 1, 0),
                            arrayListOf(1, 0, 1),
                            arrayListOf(0, 1, 0)
                        )
                    ),
            Seed(
                arrayListOf(
                    arrayListOf(0, 1, 0),
                    arrayListOf(0, 1, 0),
                    arrayListOf(0, 1, 0),
                )
            ) to
                    Seed(
                        arrayListOf(
                            arrayListOf(0, 0, 0),
                            arrayListOf(1, 1, 1),
                            arrayListOf(0, 0, 0)
                        )
                    ),
            Seed(
                arrayListOf(
                    arrayListOf(1, 1),
                    arrayListOf(1, 1)
                )
            ) to
                    Seed(
                        arrayListOf(
                            arrayListOf(1, 1),
                            arrayListOf(1, 1)
                        )
                    )
        ).forEach { (inputSeed, outputSeed) ->
            it("should generate next seed for the given input") {
                val result = gameService.generateNextSeed(inputSeed)
                result.print()
                result shouldBe outputSeed

            }
        }
    }

    describe("aliveNeighboursCount") {
        val initialSeed = Seed(
            arrayListOf(
                arrayListOf(1, 1, 0),
                arrayListOf(1, 0, 1),
                arrayListOf(0, 1, 0)
            )
        )
        gameService.generateNextSeed(initialSeed)

        mapOf(
            listOf(0, 0) to 2,
            listOf(0, 1) to 3,
            listOf(0, 2) to 2,
            listOf(1, 0) to 3,
            listOf(1, 1) to 5,
            listOf(1, 2) to 2,
            listOf(2, 0) to 2,
            listOf(2, 1) to 2,
            listOf(2, 2) to 2,
        ).forEach { (key, value) ->
            it("should return the correct neighbour count of cell element [${key[0]},${key[1]}] ") {
                val result = gameService.aliveNeighboursCount(key[0], key[1])
                result shouldBe value
            }
        }

    }
})
