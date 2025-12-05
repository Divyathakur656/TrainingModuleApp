package com.assignment.practicemvvm.viemodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.assignment.practicemvvm.models.TrainingListModel
import com.assignment.practicemvvm.models.TrainingRepository


class MoviesViewModel(application: Application) : AndroidViewModel(application) {
    private val repo = TrainingRepository(application.applicationContext)

    val modules: LiveData<List<TrainingListModel>> = repo.modulesLive


    fun reloadModule(){
        repo.loadModulesFromPrefs()
    }

}