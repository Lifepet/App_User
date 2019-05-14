package com.example.app_user.ui.detail_adopt

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.example.app_user.connecter.Connecter
import com.example.app_user.model.AdoptListModel
import com.example.app_user.util.SingleLiveEvent
import com.example.app_user.util.getToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailAdoptViewModel(val app: Application) : AndroidViewModel(app) {
    val adoptModel = MutableLiveData<AdoptListModel>()
    val postId = MutableLiveData<String>()
    val backMain = SingleLiveEvent<Any>()
    fun backtoMain() = backMain.call()
    fun getAdoptDetail() {
        Connecter.api.getAdoptDetail(getToken(app.applicationContext), postId.value!!)
            .enqueue(object : Callback<AdoptListModel> {
                override fun onResponse(call: Call<AdoptListModel>, response: Response<AdoptListModel>) {
                    adoptModel.value = response.body()
                }

                override fun onFailure(call: Call<AdoptListModel>, t: Throwable) {

                }

            })
    }
}