package ru.siksmfp.kotlin.streams.util

import ru.siksmfp.kotlin.streams.context.Configuration.INT_SIZE
import java.nio.ByteBuffer

fun intToByteBuffer(int: Int): ByteBuffer {
    return ByteBuffer.allocate(INT_SIZE)
            .putInt(int)
}

fun byteArrayToInt(byteArray: ByteArray): Int {
    return ByteBuffer.wrap(byteArray).int
}