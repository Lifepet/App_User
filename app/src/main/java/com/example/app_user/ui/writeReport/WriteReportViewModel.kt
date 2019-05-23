package com.example.app_user.ui.writeReport

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

class WriteReportViewModel(val app: Application) : AndroidViewModel(app) {

    val getImage = SingleLiveEvent<Any>()
    val imageUri = MutableLiveData<File>()
    val reportTitle = MutableLiveData<String>()
    val reportPlace = MutableLiveData<String>()
    val reportContent = MutableLiveData<String>()
    val gotoMain = SingleLiveEvent<Any>()

    fun imageLoad() {
        getImage.call()
    }

    fun postReport() {
        val file = File(imageUri.value?.toURI())
        val requestBody = RequestBody.create(MediaType.parse("image/*"), file)
        val title = RequestBody.create(MediaType.parse("text/plane"), reportTitle.value.toString())
        val content = RequestBody.create(MediaType.parse("text/plane"), reportContent.value.toString())
        val place = RequestBody.create(MediaType.parse("text/plane"), reportPlace.value.toString())
        val fileName = MultipartBody.Part.createFormData("image", file.name, requestBody)
        Connecter.api.postReport(getToken(app.applicationContext), title, place, content, fileName)
            .enqueue(object : Callback<Unit> {

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