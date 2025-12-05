package com.assignment.practicemvvm.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TrainingListModel (
    @SerializedName("id")
    val id: Int,
    val title: String, val description :String, val status: Boolean = false): Serializable
