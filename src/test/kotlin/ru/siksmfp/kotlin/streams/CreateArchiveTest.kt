package ru.siksmfp.kotlin.streams

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.FileOutputStream
import java.io.FileWriter
import java.io.PrintWriter
import java.nio.file.Files
import java.nio.file.Paths


class CreateArchiveTest {

    private val mainTestDir = Paths.get("./mytest/")
    private val dir1 = Paths.get("./mytest/dir1")
    private val dir2 = Paths.get("./mytest/test2")
    private val dir3 = Paths.get("./mytest/dir2/dir1")

    private val file1 = Paths.get("./mytest/dir1/file1")
    private val file2 = Paths.get("./mytest/dir1/file2")
    private val file3 = Paths.get("./mytest/test2/file3")
    private val file4 = Paths.get("./mytest/file4")
    private val file5 = Paths.get("./mytest/dir2/file5")

    private val file1Content = "File_1_Content"
    private val file2Content = "File_2_Content_!@#$%^&*()_"
    private val file3Content = ""
    private val file4Content = "123456"
    private val file5Content = "Content"

    @BeforeEach
    fun createFilesForTest() {
        arrayOf(dir1, dir2, dir3).forEach { Files.createDirectories(it) }
        arrayOf(file1, file2, file3, file4, file5).forEach { Files.createFile(it) }

        writeCharacterFile(file1.toFile().absolutePath, file1Content)
        writeBinaryFile(file2.toFile().absolutePath, file2Content)
        writeCharacterFile(file3.toFile().absolutePath, file3Content)
        writeBinaryFile(file4.toFile().absolutePath, file4Content)
        writeManyStringsToFile(file5.toFile().absolutePath, file5Content)
    }

    @AfterEach
    fun removeFiles() {
        Files.walk(mainTestDir)
                .sorted(reverseOrder())
                .forEach { Files.delete(it) }
    }

    @Test
    fun writeReadTest() {

    }

    private fun writeCharacterFile(path: String, content: String) {
        val fileWriter = FileWriter(path)
        val printWriter = PrintWriter(fileWriter)
        printWriter.printf(content)
        printWriter.close()
    }

    private fun writeBinaryFile(path: String, content: String) {
        val outputStream = FileOutputStream(path)
        val strToBytes = content.toByteArray()
        outputStream.write(strToBytes)

        outputStream.close()
    }

    private fun writeManyStringsToFile(path: String, contentToRepeat: String) {
        val fileWriter = FileWriter(path)
        val printWriter = PrintWriter(fileWriter)
        for (i in 0..1000) {
            printWriter.printf(contentToRepeat)
        }
        printWriter.close()
    }
}