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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class LostWriteViewModel(val app: Application) : AndroidViewModel(app) {

    val getImage = SingleLiveEvent<Any>()
    val imageUri = MutableLiveData<File>()
    val lostTitle = MutableLiveData<String>()
    val lostSection = MutableLiveData<String>()
    val lostName = MutableLiveData<String>()
    val lostContent = MutableLiveData<String>()
    val gotoMain = SingleLiveEvent<Any>()

    fun imageLoad() {
        getImage.call()
    }

    fun postLost() {
        val file = File(imageUri.value?.toURI())
        val requestBody = RequestBody.create(MediaType.parse("image/*"), file)
        val title = RequestBody.create(MediaType.parse("text/plane"), lostTitle.value.toString())
        val content = RequestBody.create(MediaType.parse("text/plane"), lostContent.value.toString())
        val section = RequestBody.create(MediaType.parse("text/plane"), lostSection.value.toString())
        val name = RequestBody.create(MediaType.parse("text/plane"), lostName.value.toString())
        val fileName = MultipartBody.Part.createFormData("image", file.name, requestBody)
        Connecter.api.postFind(
            getToken(app.applicationContext),
            title,
            RequestBody.create(MediaType.parse("text/plane"), "남"),
            name,
            content,
            section,
            fileName
        ).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.code() == 201) {
                    gotoMain.call()
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }
}