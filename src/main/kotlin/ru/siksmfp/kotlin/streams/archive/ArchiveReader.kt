package ru.siksmfp.kotlin.streams.archive

import ru.siksmfp.kotlin.streams.context.Configuration
import ru.siksmfp.kotlin.streams.file.FileEntry
import ru.siksmfp.kotlin.streams.file.HeaderProcessor
import ru.siksmfp.kotlin.streams.util.byteArrayToInt
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Paths

class ArchiveReader(targetPath: String) {

    private val inputStream: InputStream = Files.newInputStream(Paths.get(targetPath))
    private val fileList = ArrayList<String>()

    fun getFileBufferSize() {
        val bufferSize = byteArrayToInt(inputStream.readNBytes(Configuration.INT_SIZE))
    }

    fun readEntryForFile(): FileEntry {
        val headerSize = byteArrayToInt(inputStream.readNBytes(Configuration.INT_SIZE))
        val fileHeader = HeaderProcessor.deserializeHeader(inputStream.readNBytes(headerSize))
        val content = inputStream.readNBytes(fileHeader.bodySize)

        return FileEntry(fileHeader, content)
    }
}