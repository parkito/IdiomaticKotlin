package ru.siksmfp.kotlin.streams.resource

import java.io.InputStream

data class ReadableResource(
        val input: InputStream, //todo it is not optimal. Don't store input streams here
        val relativeName: String,
        val parentDirectory: String
)