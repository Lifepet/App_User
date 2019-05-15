package com.example.app_user.ui.writeReview

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.net.Uri
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
    val file = File(imageUri.value.toString())
    val requsetBody = RequestBody.create(MediaType.parse("image/*"), file)
    val successPost = SingleLiveEvent<Any>()

    fun imageLoad() {
        getImage.call()
    }

    fun postReview() {
        Connecter.api.postReview(
            getToken(app.applicationContext),
            getData(reviewTitle.value!!),
            getData(reviewContent.value!!),
            getData("나야나"),
            getData("8888888"),
            getData("2019-05-14"),
            MultipartBody.Part.createFormData("image", file.name, requsetBody)
        ).enqueue(object : Callback<Void> {

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                successPost.call()
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(app.applicationContext, "실패띠", Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun getData(st: String): RequestBody {
        return RequestBody.create(MediaType.parse("text/plane"), st)
    }
}