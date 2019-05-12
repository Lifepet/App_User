package com.example.app_user.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class AdoptListModel(
    var post_id: String,
    var image: String,
    var title: String,
    var content: String,
    var creation_date: String,
    var sex: String
)
