package ru.siksmfp.kotlin.streams.context

import ru.siksmfp.kotlin.streams.util.intToByteBuffer
import java.nio.ByteBuffer

object Configuration {
    private var bufferSize: Int = 2048
    private var arrayBufferSize: ByteBuffer

    init {
        arrayBufferSize = updateSize(bufferSize)
    }

    const val INT_SIZE = 4

    fun setBufferSize(size: Int) {
        bufferSize = size
        updateSize(size)
    }

    fun getBufferSize(): Int {
        return bufferSize
    }

    fun getBufferArraySize(): ByteBuffer {
        return arrayBufferSize
    }

    private fun updateSize(size: Int): ByteBuffer {
        return intToByteBuffer(size)
    }
}