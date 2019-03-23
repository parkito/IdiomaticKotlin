package ru.siksmfp.kotlin.streams

import ru.siksmfp.kotlin.streams.encryptor.api.DirectoryEncryptor

class DirectoryCompressor(val encryptor: DirectoryEncryptor){

    fun compressTo(directory: String, targetDirResource: ReadableResource){}
    fun comperssResource(resource: ReadableResource): ReadableResource {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}