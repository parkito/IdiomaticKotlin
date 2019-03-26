package ru.siksmfp.kotlin.streams.archive

import ru.siksmfp.kotlin.streams.context.Configuration
import ru.siksmfp.kotlin.streams.context.Configuration.INT_SIZE
import ru.siksmfp.kotlin.streams.file.FileEntry
import ru.siksmfp.kotlin.streams.file.HeaderProcessor
import ru.siksmfp.kotlin.streams.util.byteArrayToInt
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Paths

class ArchiveFileExtractor(
         private val archiveFilePath: String,
         private val targetPath: String) {


    fun extract() {


    }
}