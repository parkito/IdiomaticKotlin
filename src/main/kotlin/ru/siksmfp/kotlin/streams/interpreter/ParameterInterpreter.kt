package ru.siksmfp.kotlin.streams.interpreter

import picocli.CommandLine
import ru.siksmfp.kotlin.streams.archive.ArchiveFileBuilder
import ru.siksmfp.kotlin.streams.archive.ArchiveFileExtractor
import ru.siksmfp.kotlin.streams.archive.ArchiveFileWriter
import ru.siksmfp.kotlin.streams.encryptor.ResourceEncryptor
import ru.siksmfp.kotlin.streams.directory.DirectoryReader
import ru.siksmfp.kotlin.streams.encryptor.api.Algorithm
import ru.siksmfp.kotlin.streams.encryptor.EncryptorFactory

class ParameterInterpreter(private val args: Array<String>) {

    fun run() {
        if (args.isEmpty()) {
            throw IllegalArgumentException("Please enter parameters")
        }

        val karchiver = Karchiver()
        try {
            CommandLine(karchiver).parse(*args)
        } catch (ex: Exception) {
            print(ex.localizedMessage)
        }

        if (karchiver.isExtract) {
            ArchiveFileExtractor(karchiver.resourceFile, karchiver.targetPath).extract()
        } else {
            val reader = DirectoryReader(karchiver.resourceFile)
            val algorithm = EncryptorFactory.get(Algorithm.valueOf(karchiver.algorithm))
            val encryptor = ResourceEncryptor(algorithm)

            ArchiveFileBuilder(reader, encryptor).startBuilding()
            ArchiveFileWriter(karchiver.targetPath).startWriting()
        }
    }
}
