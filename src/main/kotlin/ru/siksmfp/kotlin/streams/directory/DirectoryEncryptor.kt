package ru.siksmfp.kotlin.streams.directory

import ru.siksmfp.kotlin.streams.encryptor.api.DirectoryEncryptor
import ru.siksmfp.kotlin.streams.resource.EncryptedResource
import ru.siksmfp.kotlin.streams.resource.ReadableResource

class DirectoryEncryptor(private val encryptor: DirectoryEncryptor) {

    fun getResource(resource: ReadableResource): EncryptedResource {
        return EncryptedResource(resource, encryptor)
    }
}