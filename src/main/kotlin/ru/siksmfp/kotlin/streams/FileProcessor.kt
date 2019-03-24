package ru.siksmfp.kotlin.streams

import ru.siksmfp.kotlin.streams.directory.DirectoryEncryptor
import ru.siksmfp.kotlin.streams.directory.DirectoryReader
import ru.siksmfp.kotlin.streams.directory.DirectoryWriter

class FileProcessor(
        private val reader: DirectoryReader,
        private val writer: DirectoryWriter,
        private val encryptor: DirectoryEncryptor) {

    fun encrypt() {
        while (true) {
            val nextIndex = reader.getNextIndex() ?: break
            val readResource = reader.getResource(nextIndex)
            val encryptedResource = encryptor.getResource(readResource)
            writer.writeResource(encryptedResource)
            println(encryptedResource)
        }
    }
}
