package ru.siksmfp.kotlin.streams.resource

import ru.siksmfp.kotlin.streams.encryptor.api.Encryptor

data class EncryptedResource(private val readableResource: ReadableResource,
                             private val encryptor: Encryptor) {

    fun readNBytes(size: Int): ByteArray {
        return encryptor.encryptChunk(readableResource.input.readNBytes(size))
    }

    fun getRelativePath(): String {
        return readableResource.relativeName
    }
}