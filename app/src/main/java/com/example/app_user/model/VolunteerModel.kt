package com.example.app_user.model

data class VolunteerModel(
    var post_id: String,
    var image: String,
    var title: String,
    var content: String,
    var creation_date: String,
    var sex: String,
    var author: String,
    var current_location: String,
    var destination_location: String
)