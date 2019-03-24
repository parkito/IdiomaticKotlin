package ru.siksmfp.kotlin.streams.encryptor.impl

import ru.siksmfp.kotlin.streams.encryptor.api.DirectoryEncryptor

class NoonEncryptor : DirectoryEncryptor {
    override fun encryptLine(line: ByteArray): ByteArray {
        return line
    }

}