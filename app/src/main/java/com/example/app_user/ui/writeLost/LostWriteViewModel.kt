package com.example.app_user.ui.writeLost

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.example.app_user.connecter.Connecter
import com.example.app_user.util.SingleLiveEvent
import com.example.app_user.util.getToken
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

class LostWriteViewModel(val app: Application) : AndroidViewModel(app) {

    val getImage = SingleLiveEvent<Any>()
    val imageUri = MutableLiveData<File>()
    val lostTitle = MutableLiveData<String>()
    val lostPlace = MutableLiveData<String>()
    val lostSection = MutableLiveData<String>()
    val lostAge = MutableLiveData<String>()
    val lostContent = MutableLiveData<String>()

    fun imageLoad() {
        getImage.call()
    }

    fun postLost() {
        val file = File(imageUri.value?.toURI())
        val requestBody = RequestBody.create(MediaType.parse("image/*"), file)
        val title = RequestBody.create(MediaType.parse("text/plane"), lostTitle.value.toString())
        val content = RequestBody.create(MediaType.parse("text/plane"), lostContent.value.toString())
        val section = RequestBody.create(MediaType.parse("text/plane"), lostSection.value.toString())
        val age = RequestBody.create(MediaType.parse("text/plane"), lostAge.value.toString())
        val place = RequestBody.create(MediaType.parse("text/plane"), lostPlace.value.toString())
        val fileName = MultipartBody.Part.createFormData("image", file.name, requestBody)
    }
}