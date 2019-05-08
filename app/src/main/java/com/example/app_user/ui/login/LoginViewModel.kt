package com.example.app_user.ui.login

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.preference.PreferenceManager
import android.view.View
import android.widget.Toast
import com.example.app_user.connecter.Connecter
import com.example.app_user.model.LoginModel
import com.example.app_user.util.SingleLiveEvent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {
    val editId = MutableLiveData<String>()
    val editPassword = MutableLiveData<String>()
    val touchLogin = SingleLiveEvent<Any>()
    val touchSignup = SingleLiveEvent<Any>()
    fun loginTouch(view: View) {
        if (editId.value.isNullOrBlank() || editPassword.value.isNullOrBlank()) {
            Toast.makeText(view.context, "입력이 바르지 않습니다.", Toast.LENGTH_SHORT).show()
        } else {
            login()
        }
    }

    fun signupTouch() = touchSignup.call()

    fun login() {
        Connecter.api.login(hashMapOf("username" to editId.value, "password" to editPassword.value))
            .enqueue(object : Callback<LoginModel> {

                override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                    when (response.code()) {
                        200 -> {
                            touchLogin.call()
                        }
                    }
                }

                override fun onFailure(call: Call<LoginModel>, t: Throwable) {

                }
            })
    }
}