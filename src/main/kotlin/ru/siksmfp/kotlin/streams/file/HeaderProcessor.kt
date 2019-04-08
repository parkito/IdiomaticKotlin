package ru.siksmfp.kotlin.streams.file

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutput
import java.io.ObjectOutputStream

class HeaderProcessor {

    companion object {
        fun serializeHeader(header: FileHeader): ByteArray {
            try {
                val baos = ByteArrayOutputStream()
                val ous: ObjectOutput = ObjectOutputStream(baos)
                ous.writeObject(header)
                return baos.toByteArray()
            } catch (ex: Exception) {
                throw IllegalStateException("Can't serialize file header ${header.relativePath}")
            }
        }

        fun deserializeHeader(header: ByteArray): FileHeader {
            try {
                val bis = ByteArrayInputStream(header)
                val ous = ObjectInputStream(bis)
                return ous.readObject() as FileHeader
            } catch (ex: Exception) {
                throw IllegalStateException("Can't deserialize file header")
            }
        }
    }
}