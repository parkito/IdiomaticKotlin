package ru.siksmfp.kotlin.streams.archive

import ru.siksmfp.kotlin.streams.context.FileEntryQueue
import java.io.RandomAccessFile
import java.nio.ByteBuffer


class ArchiveFileWriter(private val targetDirectory: String) {
    fun startWriting() {
//        val targetPath = Paths.get(targetDirectory)
        val stream = RandomAccessFile(targetDirectory, "rw")
        val channel = stream.channel

        while (FileEntryQueue.size() > 0) {
            val fileEntry = FileEntryQueue.poll()
            println(fileEntry)
            val fileContent = ByteBuffer.wrap(fileEntry!!.entryContent)
            channel.write(fileContent)
        }
    }
}
