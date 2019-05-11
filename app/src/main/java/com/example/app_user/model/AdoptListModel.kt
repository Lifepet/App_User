package com.example.app_user.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class AdoptListModel(
    var postId: String,
    var image: String,
    var title: String,
    var content: String,
    var creationDate: String,
    var sex: String
)
