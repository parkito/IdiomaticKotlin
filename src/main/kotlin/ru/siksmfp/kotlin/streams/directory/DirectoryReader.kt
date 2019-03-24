package ru.siksmfp.kotlin.streams.directory

import ru.siksmfp.kotlin.streams.resource.ReadableResource
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

class DirectoryReader(val directory: String) {

    private val fileList = ArrayList<Path>()
    private val currentPath: Path
    private var dirSubPaths = 0
    private var currentIndex = -1

    init {
        val path = Paths.get(directory)
        if (!Files.exists(path)) {
            throw IllegalStateException("Directory $directory doesn't exists")
        }

        if (!Files.isDirectory(path)) {
            throw IllegalStateException("$directory is not directory")
        }

        currentPath = Paths.get(directory)
        dirSubPaths = directory.split("/").size

        Files.walk(Paths.get(directory))
                .filter { f -> f != currentPath }
                .filter { f -> !f.toFile().isDirectory }
                .forEach { f -> this.fileList.add(f) }
    }

    @Synchronized
    fun getNextIndex(): Int? {
        if (currentIndex < fileList.size - 1) {
            return ++currentIndex
        }
        return null
    }

    fun getResource(index: Int): ReadableResource {
        val filePath = fileList[index]
        val fileInput = Files.newInputStream(filePath)
        val fileName = filePath.toFile().path
        val relativeSubPath = fileName.substring(directory.length + 1, fileName.length)
        return ReadableResource(fileInput, relativeSubPath, directory)
    }
}