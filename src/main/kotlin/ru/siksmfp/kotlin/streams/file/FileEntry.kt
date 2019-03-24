package ru.siksmfp.kotlin.streams.file

data class FileEntry(
        val header: FileHeader,
        val entryContent: ByteArray) {}