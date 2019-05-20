package com.example.app_user.ui.main.declaration.lost

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel;
import com.example.app_user.connecter.Connecter
import com.example.app_user.model.LostModel
import com.example.app_user.util.getToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LostViewModel(val app:Application) : AndroidViewModel(app) {

    val lostModel=MutableLiveData<ArrayList<LostModel>>()
    val postId=MutableLiveData<String>()

    fun getLost(){
        Connecter.api.getLost(getToken(app.applicationContext)).enqueue(object : Callback<ArrayList<LostModel>>{
            override fun onResponse(call: Call<ArrayList<LostModel>>, response: Response<ArrayList<LostModel>>) {
                lostModel.value=response.body()
            }

            override fun onFailure(call: Call<ArrayList<LostModel>>, t: Throwable) {

            }

        })
    }
}
