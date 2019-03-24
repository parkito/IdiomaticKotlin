package ru.siksmfp.kotlin.streams

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
