package ru.siksmfp.kotlin.streams.archive

import java.io.RandomAccessFile
import java.nio.ByteBuffer
import java.nio.file.Files
import java.nio.file.Paths

class FileExtractor(
        private val reader: ArchiveFileReader,
        private val targetPath: String) {

    fun extract() {
        val fullPath = targetPath + reader.relativePath
        if (Files.exists(Paths.get(fullPath))) {
            throw IllegalStateException("Can't extract file $fullPath. File already exists.")
        }

        val stream = RandomAccessFile(fullPath, "rw")
        val channel = stream.channel

        for (entryCount in 0..reader.entries) {
            val fileEntry = reader.readNextEntry().entryContent
            channel.write(ByteBuffer.wrap(fileEntry))
        }

    }

}
