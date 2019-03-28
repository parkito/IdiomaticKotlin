package ru.siksmfp.kotlin.streams.archive

import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Paths

class ArchiveFileExtractor(
        private val archiveFilePath: String,
        private val targetPath: String) {

    private val archiveContent = ArchiveContent(archiveFilePath);

    fun extract() {
        while (true) {
            val fileInfo = archiveContent.getNextFile() ?: break
            val inputStream: InputStream = Files.newInputStream(Paths.get(archiveFilePath)) //improve input stream reusing algorithm
            val archiveReader = ArchiveFileReader(fileInfo.key, fileInfo.value, inputStream)
            FileExtractor(archiveReader, targetPath).extract()
        }
    }
}