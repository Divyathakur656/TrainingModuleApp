package com.assignment.practicemvvm.models

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class TrainingRepository(private val context: Context) {

    private val prefs = context.getSharedPreferences(
        "training_modules_prefs", Context.MODE_PRIVATE
    )

    private val moduleList = listOf(
        TrainingListModel(
            id = 1,
            title = "Android Basics",
            description = "Full description for Item Android Basics"
        ),
        TrainingListModel(
            id = 2,
            title = "Coroutines",
            description = "Full description for Item Coroutines"
        ),
        TrainingListModel(
            id = 3,
            title = "Design Pattern",
            description = "Full description for Item Design Pattern"
        )
    )

    private val _modulesLive = MutableLiveData<List<TrainingListModel>>()
    val modulesLive: LiveData<List<TrainingListModel>> = _modulesLive

    init {
        loadModulesFromPrefs()
    }

     fun loadModulesFromPrefs() {
        val updated = moduleList.map { m ->
            m.copy(status = prefs.getBoolean(keyFor(m.id), false))
        }
        _modulesLive.value = updated
    }

    fun getModuleById(id: Int): TrainingListModel? {
        return _modulesLive.value?.find { it.id == id }
    }

    fun setCompleted(id: Int, completed: Boolean) {
        prefs.edit().putBoolean(keyFor(id), completed).apply()
        val updated = _modulesLive.value?.map { m ->
            if (m.id == id) m.copy(status = completed) else m
        }
        _modulesLive.value = updated!!
    }

    private fun keyFor(id: Int): String = "module_completed_$id"
}
