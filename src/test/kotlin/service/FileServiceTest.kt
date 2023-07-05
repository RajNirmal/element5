package service

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import org.nirmal.data.Seed
import org.nirmal.service.FileService
import kotlin.math.exp

class FileServiceTest : DescribeSpec({
    val fileService = FileService()

    describe("readFile") {
        it("should read file and return the required data object") {
            val expectedOutput = Seed(arrayListOf(
                arrayListOf(true, true, false),
                arrayListOf(true, false, true),
                arrayListOf(false, true, false)
            ))

            val output = fileService.readFile()

            output.shouldBe(expectedOutput)
        }

        it("should throw exception when the file is not found"){
            assertThrows<Exception> {  fileService.readFile("input2.txt")}
        }
    }
})
