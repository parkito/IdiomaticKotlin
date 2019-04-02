package ru.siksmfp.kotlin.streams.archive

import ru.siksmfp.kotlin.streams.encryptor.ResourceEncryptor
import ru.siksmfp.kotlin.streams.directory.DirectoryReader
import ru.siksmfp.kotlin.streams.file.FileEntryWriter

class ArchiveFileBuilder(
        private val reader: DirectoryReader,
        private val encryptor: ResourceEncryptor) {

    private val fileBuilder = FileEntryWriter()

    fun startBuilding() {
        while (true) {
            val nextIndex = reader.getNextIndex() ?: break
            val readResource = reader.getResource(nextIndex)
            val encryptedResource = encryptor.getResource(readResource)
            fileBuilder.writeResource(encryptedResource)
        }
    }
}
