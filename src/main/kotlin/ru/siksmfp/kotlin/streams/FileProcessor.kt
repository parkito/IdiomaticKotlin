package ru.siksmfp.kotlin.streams

import ru.siksmfp.kotlin.streams.encryptor.DirectoryWriter

class FileProcessor(
        private val reader: DirectoryReader,
        private val writer: DirectoryWriter,
        private val compressor: DirectoryCompressor) {

    fun encrypt() {
        var nextIndex = reader.getNextIndex()
        while (nextIndex != null) {
            val resource = reader.getResource(nextIndex)
            println(resource)
            nextIndex=reader.getNextIndex()
//            val compressedResource = compressor.comperssResource(resource)
//            writer.writeResource(compressedResource)
        }
    }
}