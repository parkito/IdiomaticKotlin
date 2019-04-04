package ru.siksmfp.kotlin.streams

import java.io.File


internal class MainKtTest

fun main() {
    val currentDirectory = File(File(".").absolutePath)
    println(currentDirectory.canonicalPath)
    println(currentDirectory.absolutePath)
}