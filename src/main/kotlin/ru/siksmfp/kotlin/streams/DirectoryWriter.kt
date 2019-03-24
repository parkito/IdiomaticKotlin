package ru.siksmfp.kotlin.streams

import ru.siksmfp.kotlin.streams.resource.EncryptedResource

class DirectoryWriter(val targetPath: String) {
    fun writeResource(resource: EncryptedResource) {
        while (true) {
            val fileChunk = resource.readNBytes(Configuration.getBufferSize())
            if (fileChunk.isEmpty()) {
                break
            }
        }
    }
}