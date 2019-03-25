package ru.siksmfp.kotlin.streams.archive

import ru.siksmfp.kotlin.streams.context.FileEntryQueue
import ru.siksmfp.kotlin.streams.file.HeaderProcessor
import ru.siksmfp.kotlin.streams.util.intToByteBuffer
import java.io.RandomAccessFile
import java.nio.ByteBuffer


class ArchiveFileWriter(private val targetDirectory: String) {
    fun startWriting() {
        val stream = RandomAccessFile(targetDirectory, "rw")
        val channel = stream.channel

        while (FileEntryQueue.size() > 0) {
            val fileEntry = FileEntryQueue.poll()
            val header = ByteBuffer.wrap(HeaderProcessor.serializeHeader(fileEntry.header))
            val fileContent = ByteBuffer.wrap(fileEntry.entryContent)

            channel.write(intToByteBuffer(fileEntry.header.headerSize))
            channel.write(header)
            channel.write(fileContent)
        }
    }
}
