package com.example.app_user.model

data class ReviewModel(
    var post_id: String,
    var image: String,
    var title: String,
    var content: String,
    var creation_date: String,
    var author:String
)