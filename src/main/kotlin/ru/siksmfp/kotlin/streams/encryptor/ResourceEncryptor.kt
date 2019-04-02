package ru.siksmfp.kotlin.streams.encryptor

import ru.siksmfp.kotlin.streams.encryptor.api.Encryptor
import ru.siksmfp.kotlin.streams.resource.EncryptedResource
import ru.siksmfp.kotlin.streams.resource.ReadableResource

class ResourceEncryptor(private val encryptor: Encryptor) {

    fun getResource(resource: ReadableResource): EncryptedResource {
        return EncryptedResource(resource, encryptor)
    }
}