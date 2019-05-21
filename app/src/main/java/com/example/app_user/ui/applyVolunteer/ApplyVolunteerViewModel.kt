package com.example.app_user.ui.applyVolunteer

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.example.app_user.connecter.Connecter
import com.example.app_user.util.SingleLiveEvent
import com.example.app_user.util.getToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApplyVolunteerViewModel(val app: Application) : AndroidViewModel(app) {

    val volunteerTime = MutableLiveData<String>()
    val volunteerId = MutableLiveData<String>()
    val volunteerContent = MutableLiveData<String>()
    val postId = MutableLiveData<String>()
    val volunteerApply = SingleLiveEvent<Any>()

    fun postFindApply() {
        Connecter.api.postFindApply(
            getToken(app.applicationContext),
            postId.value!!,
            hashMapOf(
                "possible_time" to volunteerTime.value,
                "phone" to volunteerId.value,
                "content" to volunteerContent.value
            )
        ).enqueue(object : Callback<Unit> {

            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.code() == 201) {
                    volunteerApply.call()
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
            }

        })
    }
}