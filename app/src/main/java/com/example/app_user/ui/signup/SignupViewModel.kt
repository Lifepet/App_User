package com.example.app_user.ui.signup

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.example.app_user.connecter.Connecter
import com.example.app_user.util.SingleLiveEvent
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupViewModel : ViewModel() {
    val textName = MutableLiveData<String>()
    val textId = MutableLiveData<String>()
    val textPw = MutableLiveData<String>()
    val textPwCheck = MutableLiveData<String>()
    val textPet = MutableLiveData<Int>()
    val signupEvent = SingleLiveEvent<Any>()
    fun signUp() = join()

    fun join() {
        if (textPw.value == textPwCheck.value) {
            Connecter.api.join(
                hashMapOf(
                    "username" to textName.value,
                    "id" to textId.value,
                    "pw" to textPw.value,
                    "pet" to textPet.value
                )
            ).enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    when (response.code()) {
                        201 -> signupEvent.call()
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {

                }
            })
        }
    }
}