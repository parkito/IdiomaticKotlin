package ru.siksmfp.kotlin.streams.context

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
        return ByteBuffer.allocate(INT_SIZE)
                .putInt(size)

    }
}