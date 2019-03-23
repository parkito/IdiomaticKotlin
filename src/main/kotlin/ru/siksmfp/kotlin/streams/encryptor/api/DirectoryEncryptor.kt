package ru.siksmfp.kotlin.streams.encryptor.api

interface DirectoryEncryptor {
    fun encryptLine(line: ByteArray): ByteArray
}