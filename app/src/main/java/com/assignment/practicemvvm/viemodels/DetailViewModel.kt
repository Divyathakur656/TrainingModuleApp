package com.assignment.practicemvvm.viemodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.assignment.practicemvvm.models.TrainingListModel
import com.assignment.practicemvvm.models.TrainingRepository


class DetailViewModel(application: Application) : AndroidViewModel(application) {
    private val repo = TrainingRepository(application.applicationContext)

    private val _module = MutableLiveData<TrainingListModel?>()
    val module: LiveData<TrainingListModel?> = _module

    fun load(id: Int) {
        _module.value = repo.getModuleById(id)
    }

    fun toggleCompleted() {
        _module.value?.let { m ->
            val newStatus = !m.status
            repo.setCompleted(m.id, newStatus)
            _module.value = m.copy(status = newStatus)
        }
    }
}