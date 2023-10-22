package com.crowthedev.band

import java.io.BufferedReader
import java.time.LocalDate

fun getNames(reader: BufferedReader, names: MutableList<String>, isToday: Boolean) {
    val data = mutableListOf<String>()
    getData(data, reader)
    val current = LocalDate.now()

    var i = 0
    if (isToday) {
        while (i < data.size) {
            if (data[i].toInt() == current.dayOfMonth && data[i + 1].toInt() == current.monthValue) {
                names.add(data[i + 2])
            }
            i += 3
        }
    } else {
        while (i < data.size) {
            if (data[i].toInt() == current.dayOfMonth + 1 && data[i + 1].toInt() == current.monthValue) {
                names.add(data[i + 2])
            }
            i += 3
        }
    }
}

// Get data from database
fun getData(data: MutableList<String>, reader: BufferedReader) {
    var line: String?
    while (reader.readLine().also { line = it } != null) {
        val a: List<String> = line!!.split(",")
        data.add(a[0])
        data.add(a[1])
        data.add(a[2])
    }
}



// TODO: Export ROOM as file







// TODO: Import ROOM as file