package com.example.app_user.ui.applyProtect

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.example.app_user.connecter.Connecter
import com.example.app_user.util.SingleLiveEvent
import com.example.app_user.util.getToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApplyProtectViewModel(val app: Application) : AndroidViewModel(app) {

    val protectPlace = MutableLiveData<String>()
    val protectDate = MutableLiveData<String>()
    val protectId = MutableLiveData<String>()
    val protectContent = MutableLiveData<String>()
    val postId = MutableLiveData<String>()
    val protectApply = SingleLiveEvent<Any>()

    fun postProtectApply() {
        Connecter.api.postProtectApply(
            getToken(app.applicationContext),
            postId.value!!,
            hashMapOf(
                "current_location" to protectPlace.value,
                "possible_month" to protectDate.value,
                "phone" to protectId.value,
                "content" to protectContent.value
            )
        ).enqueue(object : Callback<Unit> {

            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.code() == 201) {
                    protectApply.call()
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {

            }

        })
    }

}