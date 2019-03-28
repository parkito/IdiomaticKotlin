package ru.siksmfp.kotlin.streams.archive

import java.io.RandomAccessFile
import java.nio.ByteBuffer
import java.nio.file.Files
import java.nio.file.Paths

class FileExtractor(
        private val reader: ArchiveFileReader,
        private val targetPath: String) {

    fun extract() {
        val fullPath = if (reader.relativePath.startsWith("/")) targetPath + reader.relativePath else targetPath + "/" + reader.relativePath
        val directoryPath = fullPath.substring(0, fullPath.lastIndexOf("/"))

        if (Files.exists(Paths.get(fullPath))) {
            throw IllegalStateException("Can't extract file $fullPath. File already exists.")
        }

        Files.createDirectories(Paths.get(directoryPath))

        val stream = RandomAccessFile(fullPath, "rw")
        val channel = stream.channel

        for (entryCount in 0 until reader.entries) {
            val fileEntry = reader.readNextEntry().entryContent
            channel.write(ByteBuffer.wrap(fileEntry))//bug with internal tst2/
        }

        channel.close()

    }

}
