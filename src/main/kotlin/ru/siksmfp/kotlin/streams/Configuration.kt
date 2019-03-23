package ru.siksmfp.kotlin.streams

object Configuration {
    private var bufferSize: Int = 4096

    fun setBufferSize(size: Int) {
        bufferSize = size
    }

    fun getBufferSize(): Int {
        return bufferSize
    }
}