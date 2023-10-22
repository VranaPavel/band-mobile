package com.crowthedev.band.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class NameViewModel(application: Application): AndroidViewModel(application) {
    private val readAllData: Flow<List<Name>>
    private val repository: NameRepository

    init {
        val nameDao = NameDatabase.getDatabase(application).nameDao()
        repository = NameRepository(nameDao)
        readAllData = repository.readAllData
    }

    fun addName(name: Name) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addName(name)
        }
    }
}