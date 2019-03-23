package ru.siksmfp.kotlin.streams

import java.io.BufferedReader

data class ReadableResource(
        val bufferReader: BufferedReader,
        val relativeName: String
)