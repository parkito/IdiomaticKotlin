package ru.siksmfp.kotlin.streams.encryptor.api

interface Encryptor {

    fun encryptChunk(chunk: ByteArray): ByteArray
}