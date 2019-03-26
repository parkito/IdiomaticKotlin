package ru.siksmfp.kotlin.streams.archive

import ru.siksmfp.kotlin.streams.context.Configuration
import ru.siksmfp.kotlin.streams.file.FileEntry
import ru.siksmfp.kotlin.streams.file.HeaderProcessor
import ru.siksmfp.kotlin.streams.util.byteArrayToInt
import java.io.InputStream

class ArchiveFileReader(
        private val relativePath:String,
        private val entries:Int,
        private val inputStream: InputStream) {

    fun readEntryForFile(): FileEntry {
        val headerSize = byteArrayToInt(inputStream.readNBytes(Configuration.INT_SIZE))
        val fileHeader = HeaderProcessor.deserializeHeader(inputStream.readNBytes(headerSize))
        val content = inputStream.readNBytes(fileHeader.bodySize)

        return FileEntry(fileHeader, content)
    }

}