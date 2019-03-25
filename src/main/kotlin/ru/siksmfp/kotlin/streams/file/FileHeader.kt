package ru.siksmfp.kotlin.streams.file

import ru.siksmfp.kotlin.streams.context.Configuration.INT_SIZE
import java.io.Serializable

data class FileHeader(
        val relativePath: String,
        val orderNumber: Long,
        val bodySize: Int
) : Serializable {
    @Transient
    var headerSize: Int = 0
        get() = relativePath.length + INT_SIZE * 2
}