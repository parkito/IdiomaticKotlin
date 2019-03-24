package ru.siksmfp.kotlin.streams.archive

import ru.siksmfp.kotlin.streams.context.Configuration
import java.nio.ByteBuffer
import java.nio.file.Files
import java.nio.file.Paths

class ArchiveReader(private val targetPath: String) {

    fun getFileList() {
        val inputStream = Files.newInputStream(Paths.get(targetPath))
        val bufferSize = ByteBuffer.wrap(inputStream.readNBytes(Configuration.INT_SIZE)).int
    }
}