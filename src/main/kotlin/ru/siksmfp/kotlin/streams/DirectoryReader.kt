package ru.siksmfp.kotlin.streams

import java.nio.file.Files
import java.nio.file.Paths

class DirectoryReader(
        private val directoryForEncrypt: String) {

    private val fileList = ArrayList<String>()

    init {
        val path = Paths.get(directoryForEncrypt)
        if (Files.exists(path)) {
            throw IllegalStateException("Directory $directoryForEncrypt doesn't exists")
        }

        if (!Files.isDirectory(path)) {
            throw IllegalStateException("$directoryForEncrypt is not directory")
        }

        Files.list(Paths.get(directoryForEncrypt)).forEach { f -> fileList.add(f.toFile().name) }
    }

    fun readDirectory(directoryForEncrypt: String): ReadableResource {
        return ReadableResource()

    }

    fun hasNext(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun getNext(): ReadableResource {
        return ReadableResource()
    }
}