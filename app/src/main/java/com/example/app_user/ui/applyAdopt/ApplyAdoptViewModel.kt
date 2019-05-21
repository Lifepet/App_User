package com.example.app_user.ui.applyAdopt

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.app_user.connecter.Connecter
import com.example.app_user.util.SingleLiveEvent
import com.example.app_user.util.getToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApplyAdoptViewModel(val app: Application) : AndroidViewModel(app) {

    val adoptPlace = MutableLiveData<String>()
    val adoptNum = MutableLiveData<String>()
    val adoptId = MutableLiveData<String>()
    val adoptContent = MutableLiveData<String>()
    val postId = MutableLiveData<String>()
    val adoptApply = SingleLiveEvent<Any>()

    fun adoptApply() {
        Connecter.api.postAdoptApply(
            getToken(app.applicationContext),
            postId.value!!,
            hashMapOf(
                "current_location" to adoptPlace.value,
                "phone" to adoptNum.value,
                "kakao_id" to adoptId.value,
                "content" to adoptContent.value
            )
        ).enqueue(object : Callback<Unit> {

            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.code() == 201) {
                    adoptApply.call()
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }
}