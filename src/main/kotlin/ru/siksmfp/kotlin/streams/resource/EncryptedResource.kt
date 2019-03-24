package ru.siksmfp.kotlin.streams.resource

import ru.siksmfp.kotlin.streams.encryptor.api.DirectoryEncryptor

data class EncryptedResource(private val readableResource: ReadableResource,
                             private val encryptor: DirectoryEncryptor) {

    fun readNBytes(size: Int): ByteArray {
        return encryptor.encryptLine(readableResource.input.readNBytes(size))
    }
}