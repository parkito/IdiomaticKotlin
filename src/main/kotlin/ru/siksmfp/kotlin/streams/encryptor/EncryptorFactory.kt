package ru.siksmfp.kotlin.streams.encryptor

import ru.siksmfp.kotlin.streams.encryptor.api.Algorithm
import ru.siksmfp.kotlin.streams.encryptor.api.Algorithm.KEY
import ru.siksmfp.kotlin.streams.encryptor.api.Algorithm.NOON
import ru.siksmfp.kotlin.streams.encryptor.api.Encryptor
import ru.siksmfp.kotlin.streams.encryptor.impl.KeyEncryptor
import ru.siksmfp.kotlin.streams.encryptor.impl.NoonEncryptor

object EncryptorFactory {

    private val MAP: Map<Algorithm, Encryptor>

    init {
        MAP = HashMap()
        MAP[NOON] = NoonEncryptor()
        MAP[KEY] = KeyEncryptor()
    }

    fun get(algorithm: Algorithm): Encryptor {
        if (MAP[algorithm] == null) {
            throw IllegalStateException("Unknown encrypting algorithm")
        }
        return MAP.getValue(algorithm)
    }
}