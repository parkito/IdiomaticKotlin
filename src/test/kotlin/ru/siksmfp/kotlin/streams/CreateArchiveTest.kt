package ru.siksmfp.kotlin.streams

import org.junit.jupiter.api.BeforeEach
import java.nio.file.Files
import java.nio.file.Paths

class CreateArchiveTest {

    private val dir1 = Paths.get("./test/dir1")
    private val dir2 = Paths.get("./test/test2")
    private val dir3 = Paths.get("./test/dir2/dir1")

    private val file1 = Paths.get("./test/dir1/file1")
    private val file2 = Paths.get("./test/dir1/file2")
    private val file3 = Paths.get("./test/test2/file3")
    private val file4 = Paths.get("./test/file4")
    private val file5 = Paths.get("./test/dir2/file5")

    @BeforeEach
    fun createFilesForTest() {
        arrayOf(dir1, dir2, dir3).forEach { Files.createDirectories(it) }
        arrayOf(file1, file2, file3, file4, file5).forEach { Files.createFile(it) }
    }


}

fun main() {
    CreateArchiveTest().createFilesForTest()
}