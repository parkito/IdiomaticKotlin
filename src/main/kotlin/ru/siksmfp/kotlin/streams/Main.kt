package ru.siksmfp.kotlin.streams

import ru.siksmfp.kotlin.streams.archive.ArchiveFileBuilder
import ru.siksmfp.kotlin.streams.archive.ArchiveFileExtractor
import ru.siksmfp.kotlin.streams.archive.ArchiveFileWriter
import ru.siksmfp.kotlin.streams.directory.DirectoryEncryptor
import ru.siksmfp.kotlin.streams.directory.DirectoryReader
import ru.siksmfp.kotlin.streams.encryptor.Algorithm.NOON
import ru.siksmfp.kotlin.streams.encryptor.EncryptorFactory
import ru.siksmfp.kotlin.streams.interpreter.ParameterInterpreter

fun main(args: Array<String>) {

//
//    if (args[0] == "-unpack") {
//
//    }
//
//    val directoryForEncrypt = args[0]
//    val targetPath = args[1]
//    val encryptAlgorithms = if (args.size > 2) Algorithm.valueOf(args[2]) else NOON
//    val archiveFilePath = ""

    val runScenario = ParameterInterpreter(args).buildScenario()
    runScenario.action.perform()

    val directoryForEncrypt = "/Users/parkito/Downloads/test"
    val targetPath = "/Users/parkito/Downloads/test.arch"
    val archiveFilePath = "/Users/parkito/Downloads/test.arch"


    val reader = DirectoryReader(directoryForEncrypt)
    val algorithm = EncryptorFactory.get(NOON)
    val encryptor = DirectoryEncryptor(algorithm)

    ArchiveFileBuilder(reader, encryptor).startBuilding()
    ArchiveFileWriter(targetPath).startWriting()
    ArchiveFileExtractor(archiveFilePath, "/Users/parkito/Downloads/tst").extract()

    println("Archive successfully created")

}