package ru.siksmfp.kotlin.streams.interpreter

class ParameterInterpreter(private val parameters: Array<String>) {

    fun buildScenario(): RunScenario {
        if (parameters.isEmpty()) {
            throw IllegalArgumentException("Please enter path to folder")
        }
        return RunScenario()
    }
}