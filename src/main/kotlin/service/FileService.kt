package org.nirmal.service

import org.nirmal.data.Seed

class FileService {
    fun readFile(filename: String = "input.txt"): Seed {
        val fileContent = this.javaClass.classLoader.getResourceAsStream(filename)?.bufferedReader()?.readText()
        if (fileContent.isNullOrEmpty()) {
            throw Exception("File content cannot be empty")
        }
        return mapFileInputToSeed(fileContent)
    }

    private fun mapFileInputToSeed(fileContent: String): Seed {
        val fileRow = fileContent.split("\n")
        val col = ArrayList<Int>()
        val row = ArrayList<ArrayList<Int>>()
        fileRow.forEach { fileInputString ->
            fileInputString.forEach {
                col.add(transform(it))
            }
            row.add(col.clone() as ArrayList<Int>) //Clone so the object does not get reset when clear is called
            col.clear()
        }
        return Seed(row)
    }

    private fun transform(it: Char): Int = if (it == 'X') 1 else 0
}