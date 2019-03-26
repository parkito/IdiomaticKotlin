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

    fun readNextEntry(): FileEntry {
        val headerSize = byteArrayToInt(inputStream.readNBytes(INT_SIZE))
        val fileHeader = HeaderProcessor.deserializeHeader(inputStream.readNBytes(headerSize))
        var content: ByteArray? = null
        if (fileHeader.relativePath == relativePath) {
            content = inputStream.readNBytes(fileHeader.bodySize)
        } else {
            inputStream.skip(fileHeader.bodySize.toLong())
        }

        return FileEntry(fileHeader, content)
    }

}