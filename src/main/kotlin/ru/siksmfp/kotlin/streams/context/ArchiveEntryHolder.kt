package ru.siksmfp.kotlin.streams.context

import ru.siksmfp.kotlin.streams.file.FileEntry

class ArchiveEntryHolder {

    private val entryMap: MutableMap<Int, FileEntry>

    init {
        entryMap = HashMap()
    }

    fun addEntry(index: Int, entry: FileEntry) {
        entryMap[index] = entry
    }
}