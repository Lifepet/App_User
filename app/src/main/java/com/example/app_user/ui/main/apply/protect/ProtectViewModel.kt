package com.example.app_user.ui.main.apply.protect

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel;
import com.example.app_user.connecter.Connecter
import com.example.app_user.model.AdoptListModel
import com.example.app_user.model.ProtectModel
import com.example.app_user.util.SingleLiveEvent
import com.example.app_user.util.getToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProtectViewModel(val app: Application) : AndroidViewModel(app) {
    val protectModel = MutableLiveData<ArrayList<ProtectModel>>()
    val postId=MutableLiveData<String>()
    val gotoDetail=SingleLiveEvent<Any>()

    fun getProtect() {
        Connecter.api.getProtect(getToken(app.applicationContext)).enqueue(object : Callback<ArrayList<ProtectModel>> {
            override fun onResponse(
                call: Call<ArrayList<ProtectModel>>,
                response: Response<ArrayList<ProtectModel>>
            ) {
                when (response.code()) {
                    200 -> protectModel.value = response.body()
                }
            }

            override fun onFailure(call: Call<ArrayList<ProtectModel>>, t: Throwable) {

            }
        })
    }

    fun adoptTouch(index: Int) {
        postId.value = protectModel.value!![index].post_id
        gotoDetail.call()
    }
}


