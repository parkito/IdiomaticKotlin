package ru.siksmfp.kotlin.streams

import ru.siksmfp.kotlin.streams.archive.ArchiveFileBuilder
import ru.siksmfp.kotlin.streams.archive.ArchiveFileExtractor
import ru.siksmfp.kotlin.streams.archive.ArchiveFileWriter
import ru.siksmfp.kotlin.streams.directory.DirectoryEncryptor
import ru.siksmfp.kotlin.streams.directory.DirectoryReader
import ru.siksmfp.kotlin.streams.encryptor.Algorithm.NOON
import ru.siksmfp.kotlin.streams.encryptor.EncryptorFactory
import ru.siksmfp.kotlin.streams.util.byteArrayToInt
import ru.siksmfp.kotlin.streams.util.intToByteBuffer
import java.io.RandomAccessFile
import java.nio.file.Files
import java.nio.file.Paths

fun main(args: Array<String>) {
//    if (args.isEmpty()) {
//        throw IllegalArgumentException("Please enter path to folder")
//    }
//
//    if (args[0] == "-unpack") {
//
//    }
//
//    val directoryForEncrypt = args[0]
//    val targetPath = args[1]
//    val encryptAlgorithms = if (args.size > 2) Algorithm.valueOf(args[2]) else NOON
//    val archiveFilePath = ""

    val directoryForEncrypt = "/Users/parkito/Downloads/test"
    val targetPath = "/Users/parkito/Downloads/test.arch"
    val archiveFilePath = "/Users/parkito/Downloads/test.arch"


    val reader = DirectoryReader(directoryForEncrypt)
    val algorithm = EncryptorFactory.get(NOON)
    val compressor = DirectoryEncryptor(algorithm)

//    ArchiveFileBuilder(reader, compressor).startBuilding()
//    ArchiveFileWriter(targetPath).startWriting()
    ArchiveFileExtractor(archiveFilePath, "/Users/parkito/Downloads/tst").extract()

//    val stream = RandomAccessFile("/Users/parkito/Downloads/tst.file", "rw").channel
//    val a = 123;
//
//    stream.write(intToByteBuffer(105))
//    stream.close()
//    val result = Files.newInputStream(Paths.get("/Users/parkito/Downloads/tst.file")).readAllBytes()
//    println(byteArrayToInt(result))

    println("Archive successfully created")

}