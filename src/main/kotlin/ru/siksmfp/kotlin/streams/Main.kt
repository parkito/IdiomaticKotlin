package ru.siksmfp.kotlin.streams

import ru.siksmfp.kotlin.streams.interpreter.ParameterInterpreter

fun main(args: Array<String>) {
    ParameterInterpreter(args).run()
}

//todo
//0 tests
//1 improve performance by
// not storing input streams
// don't hold data in the memory
// introduce concurrency
//2 exception handling
//3 logging
//4 implement encryption
//5 implement compression