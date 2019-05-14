package com.example.app_user.ui.writeReview

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.net.Uri
import com.example.app_user.util.SingleLiveEvent
import java.io.File

class WriteReviewViewModel(val app: Application) : AndroidViewModel(app) {
    val getImage = SingleLiveEvent<Any>()
    val imageUri=MutableLiveData<File>()
    fun imageLoad() {
        getImage.call()
    }
}