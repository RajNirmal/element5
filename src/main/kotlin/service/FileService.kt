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
        val col = ArrayList<Boolean>()
        val row = ArrayList<ArrayList<Boolean>>()
        fileRow.forEach { fileInputString ->
            fileInputString.forEach {
                col.add(transform(it))
            }
            row.add(col.clone() as ArrayList<Boolean>) //Clone so the object does not get reset when clear is called
            col.clear()
        }
        return Seed(row)
    }

    private fun transform(it: Char): Boolean = (it == 'X')
}