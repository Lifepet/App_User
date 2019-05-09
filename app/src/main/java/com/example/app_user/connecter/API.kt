package com.example.app_user.connecter

import com.example.app_user.model.LoginModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface API {
    @POST("auth/join/")
    fun join(@Body body: Any): Call<Void>

    @POST("auth/login/")
    fun login(@Body body: Any):Call<LoginModel>
}