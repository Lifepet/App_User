package com.example.app_user.ui.main.adopt

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import com.bumptech.glide.Glide
import com.example.app_user.connecter.Connecter
import com.example.app_user.model.AdoptListModel
import com.example.app_user.util.LifecycleCallback
import com.example.app_user.util.SingleLiveEvent
import com.example.app_user.util.getToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdoptViewModel(val app: Application) : AndroidViewModel(app) {
    val adoptModel = MutableLiveData<ArrayList<AdoptListModel>>()
    val postId = MutableLiveData<String?>()
    val gotoDetail = SingleLiveEvent<Any>()

    fun getAdopt() {
        Connecter.api.getAdopt(getToken(app.applicationContext)).enqueue(object : Callback<ArrayList<AdoptListModel>> {
            override fun onResponse(
                call: Call<ArrayList<AdoptListModel>>,
                response: Response<ArrayList<AdoptListModel>>
            ) {
                when (response.code()) {
                    200 -> adoptModel.value = response.body()
                }
            }

            override fun onFailure(call: Call<ArrayList<AdoptListModel>>, t: Throwable) {

            }
        })
    }

    fun adoptTouch(index: Int) {
        postId.value = adoptModel.value!![index].post_id
        gotoDetail.call()
    }

}