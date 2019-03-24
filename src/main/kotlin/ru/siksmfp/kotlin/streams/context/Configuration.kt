package ru.siksmfp.kotlin.streams.context

object Configuration {
    private var bufferSize: Int = 2048

    fun setBufferSize(size: Int) {
        bufferSize = size
    }

    fun getBufferSize(): Int {
        return bufferSize
    }
}