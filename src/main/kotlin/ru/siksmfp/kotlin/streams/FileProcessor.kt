package ru.siksmfp.kotlin.streams

import ru.siksmfp.kotlin.streams.encryptor.DirectoryWriter

class FileProcessor(
        private val reader: DirectoryReader,
        private val writer: DirectoryWriter,
        private val compressor: DirectoryCompressor){

    fun encrypt() {
        while (reader.hasNext()){
            val resource = reader.getNext()
            val compressedResource = compressor.comperssResource(resource)
            writer.writeResource(compressedResource)
        }
    }
}