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
            val serializedHeader = HeaderProcessor.serializeHeader(fileEntry.header)
            val header = ByteBuffer.wrap(serializedHeader)
            val fileContent = ByteBuffer.wrap(fileEntry.entryContent)

            channel.write(intToByteBuffer(serializedHeader.size))
            channel.write(header)
            channel.write(fileContent)
        }
        channel.close()
    }
}
