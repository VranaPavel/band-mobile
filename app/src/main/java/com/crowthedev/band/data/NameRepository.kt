package com.crowthedev.band.data

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class NameRepository(private val nameDao: NameDao) {

    val readAllData: Flow<List<Name>> = nameDao.readAllData()

    @Suppress
    @WorkerThread
    suspend fun addName(name: Name) {
        nameDao.addName(name)
    }

}