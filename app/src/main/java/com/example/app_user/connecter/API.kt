package com.example.app_user.connecter

import com.example.app_user.model.AdoptListModel
import com.example.app_user.model.AdoptModel
import com.example.app_user.model.LoginModel
import retrofit2.Call
import retrofit2.http.*

interface API {
    @POST("auth/join/")
    fun join(@Body body: Any): Call<Void>

    @POST("auth/login/")
    fun login(@Body body: Any):Call<LoginModel>

    @GET("post/adoption/")
    @Headers("Content-Type: application/json")
    fun getAdopt(@Header("Authorization") token: String):Call<AdoptListModel>
}