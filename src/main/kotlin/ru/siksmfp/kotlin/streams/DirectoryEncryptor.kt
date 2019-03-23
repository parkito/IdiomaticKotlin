package ru.siksmfp.kotlin.streams

import ru.siksmfp.kotlin.streams.encryptor.api.DirectoryEncryptor
import ru.siksmfp.kotlin.streams.resource.EncryptedResource
import ru.siksmfp.kotlin.streams.resource.ReadableResource

class DirectoryEncryptor(val encryptor: DirectoryEncryptor) {

    fun getResource(resource: ReadableResource): EncryptedResource {
        while (true) {
            val fileChunk = resource.input.readNBytes(Configuration.getBufferSize())
            if (fileChunk.isEmpty()) {
                break
            }
        }

        return EncryptedResource("")//future
    }
}