package ru.siksmfp.kotlin.streams.archive

import ru.siksmfp.kotlin.streams.context.Configuration.INT_SIZE
import ru.siksmfp.kotlin.streams.file.FileEntry
import ru.siksmfp.kotlin.streams.file.HeaderProcessor
import ru.siksmfp.kotlin.streams.util.byteArrayToInt
import java.io.InputStream

class ArchiveFileReader(
        val relativePath: String,
        val entries: Int,
        private val inputStream: InputStream) {

    //todo potential infinite loop
    fun readNextEntry(): FileEntry {
        while (true) {
            val headerSize = byteArrayToInt(inputStream.readNBytes(INT_SIZE))
            val fileHeader = HeaderProcessor.deserializeHeader(inputStream.readNBytes(headerSize))
            if (fileHeader.relativePath == relativePath) {
                val content = inputStream.readNBytes(fileHeader.bodySize)
                return FileEntry(fileHeader, content)
            } else {
                inputStream.skip(fileHeader.bodySize.toLong())
            }
        }
    }
}