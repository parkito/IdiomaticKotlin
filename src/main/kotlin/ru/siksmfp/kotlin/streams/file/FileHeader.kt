package ru.siksmfp.kotlin.streams.file

import java.io.Serializable

data class FileHeader(
        val relativePath: String,
        val orderNumber: Long,
        val bodySize: Int
) : Serializable