package com.example.app_user.connecter

import com.example.app_user.model.AdoptListModel
import com.example.app_user.model.LoginModel
import com.example.app_user.model.ProtectModel
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST


interface API {
    @POST("auth/join/")
    fun join(@Body body: Any): Call<Void>

    @POST("auth/login/")
    fun login(@Body body: Any): Call<LoginModel>

    @GET("post/adoption/")
    @Headers("Content-Type: application/json")
    fun getAdopt(@Header("Authorization") token: String): Call<ArrayList<AdoptListModel>>

    @GET("post/adoption/{post_id}")
    @Headers("Content-Type: application/json")
    fun getAdoptDetail(@Header("Authorization") token: String, @Path("post_id") post_id: String): Call<AdoptListModel>

    @GET("post/care/")
    @Headers("Content-Type: application/json")
    fun getProtect(@Header("Authorization") token: String): Call<ArrayList<ProtectModel>>

    @GET("post/care/{post_id}")
    @Headers("Content-Type: application/json")
    fun getProtectDetail(@Header("Authorization") token: String, @Path("post_id") post_id: String): Call<ProtectModel>

    @POST("post/community/")
    @Headers("Content-Type: application/json")
    @Multipart
    fun postReview(
        @Header("Authorization") token: String, @Part("title") title: RequestBody, @Part("content") content: RequestBody, @Part(
            "author"
        ) author: RequestBody, @Part("post_id") post_id: RequestBody, @Part("creation_date") creation_date: RequestBody,
        @Part image: MultipartBody.Part
    ): Call<Void>


}