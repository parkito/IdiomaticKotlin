package ru.siksmfp.kotlin.streams.context

import ru.siksmfp.kotlin.streams.file.FileEntry
import java.util.concurrent.ConcurrentLinkedQueue

object FileEntryQueue {
    private val queue = ConcurrentLinkedQueue<FileEntry>()

    fun size(): Int {
        return queue.size
    }

    fun add(entry: FileEntry) {
        queue.add(entry)
    }

    fun poll(): FileEntry {
        return queue.poll()
    }
}