package ru.siksmfp.kotlin.streams.encryptor.impl

import ru.siksmfp.kotlin.streams.encryptor.api.Encryptor

class KeyEncryptor : Encryptor {
    override fun encryptChunk(chunk: ByteArray): ByteArray {
        return chunk //todo implement encryption
    }
}