package ru.siksmfp.kotlin.streams.file

import ru.siksmfp.kotlin.streams.context.Configuration
import ru.siksmfp.kotlin.streams.context.FileEntryQueue
import ru.siksmfp.kotlin.streams.resource.EncryptedResource

class FileEntryWriter {
    fun writeResource(resource: EncryptedResource) {
        var fileChunkOrder: Long = 0
        while (true) {
            val fileChunk = resource.readNBytes(Configuration.getBufferSize())
            if (fileChunk.isEmpty()) {
                break
            }
            val fileHeader = FileHeader(resource.getRelativePath(), fileChunkOrder)
            val fileEntry = FileEntry(fileHeader, fileChunk)
            FileEntryQueue.add(fileEntry)
            fileChunkOrder++
        }
    }
}