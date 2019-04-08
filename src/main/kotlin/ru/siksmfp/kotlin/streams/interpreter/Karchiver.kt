package ru.siksmfp.kotlin.streams.interpreter

import picocli.CommandLine
import java.util.*

class Karchiver {

    @CommandLine.Parameters(description = ["Resource for archiving"], index = "0")
    var resourceFile: String = ""

    @CommandLine.Parameters(description = ["Target path"], index = "1")
    var targetPath: String = ""

    @CommandLine.Option(names = ["-a", "--algorithm"], description = ["NOON, KEY"], defaultValue = "NOON")
    var algorithm = "NOON"

    @CommandLine.Option(names = ["-e", "--extract"], description = ["extract"])
    var isExtract = false

    override fun toString(): String {
        return "Karchiver(resourceFile='$resourceFile', targetPath='$targetPath', algorithm='$algorithm', isExtract=$isExtract)"
    }
}