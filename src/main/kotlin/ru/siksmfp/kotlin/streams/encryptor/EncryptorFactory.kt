package ru.siksmfp.kotlin.streams.encryptor

import ru.siksmfp.kotlin.streams.encryptor.Algorithm.KEY
import ru.siksmfp.kotlin.streams.encryptor.Algorithm.NOON
import ru.siksmfp.kotlin.streams.encryptor.api.DirectoryEncryptor
import ru.siksmfp.kotlin.streams.encryptor.impl.KeyEncryptor
import ru.siksmfp.kotlin.streams.encryptor.impl.NoonEncryptor
import java.lang.IllegalStateException

object EncryptorFactory {

    private val map: Map<Algorithm, DirectoryEncryptor>

    init {
        map = HashMap()
        map[NOON] = NoonEncryptor()
        map[KEY] = KeyEncryptor()
    }

    fun get(algorithm: Algorithm):DirectoryEncryptor {
        if (map[algorithm] == null) {
            throw IllegalStateException("Unknown encrypting algorithm")
        }
        return map.getValue(algorithm)
    }

}