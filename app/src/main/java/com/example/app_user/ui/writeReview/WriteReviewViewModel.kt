package com.example.app_user.ui.writeReview

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import android.widget.Toast
import com.example.app_user.connecter.Connecter
import com.example.app_user.util.SingleLiveEvent
import com.example.app_user.util.getToken
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import java.io.File
import retrofit2.Callback
import retrofit2.Response

class WriteReviewViewModel(val app: Application) : AndroidViewModel(app) {

    val getImage = SingleLiveEvent<Any>()
    val imageUri = MutableLiveData<File>()
    val reviewTitle = MutableLiveData<String>()
    val reviewContent = MutableLiveData<String>()
    val successPost = SingleLiveEvent<Any>()

    fun imageLoad() {
        getImage.call()
    }

    fun postReview() {
        val file = File(imageUri.value?.toURI())
        val requestBody = RequestBody.create(MediaType.parse("image/*"), file)
        val title = RequestBody.create(MediaType.parse("text/plane"), reviewTitle.value.toString())
        val content = RequestBody.create(MediaType.parse("text/plane"), reviewContent.value.toString())
        val fileName = MultipartBody.Part.createFormData("image", file.name, requestBody)
        Log.d("file", file.toString())

        Connecter.api.postReview(
            getToken(app.applicationContext),
            title, content, fileName
        ).enqueue(object : Callback<Unit> {

            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                when (response.code()) {
                    201 -> successPost.call()
                    else -> Toast.makeText(app.applicationContext, "실패함!", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Toast.makeText(app.applicationContext, "실패", Toast.LENGTH_SHORT).show()
            }

        })
    }
}