package ru.siksmfp.kotlin.streams.file

data class FileEntry(
        public val header: FileHeader,
        public val entryContent: ByteArray) {
}