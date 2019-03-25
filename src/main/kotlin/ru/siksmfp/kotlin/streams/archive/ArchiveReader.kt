package ru.siksmfp.kotlin.streams.archive

import ru.siksmfp.kotlin.streams.context.Configuration
import java.io.InputStream
import java.nio.ByteBuffer
import java.nio.file.Files
import java.nio.file.Paths

class ArchiveReader(private val targetPath: String) {

    private val inputStream: InputStream = Files.newInputStream(Paths.get(targetPath))
    private val fileList = ArrayList<String>()

    fun getFileBufferSize() {
        val bufferSize = ByteBuffer.wrap(inputStream.readNBytes(Configuration.INT_SIZE)).int
    }

    fun populateFileList() {

    }


}