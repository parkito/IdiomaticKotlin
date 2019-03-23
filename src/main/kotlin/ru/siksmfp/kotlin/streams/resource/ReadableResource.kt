package ru.siksmfp.kotlin.streams.resource

import java.io.InputStream

data class ReadableResource(
        val input: InputStream,
        val relativeName: String,
        val parentDirectory: String
)