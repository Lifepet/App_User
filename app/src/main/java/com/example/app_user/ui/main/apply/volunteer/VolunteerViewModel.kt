package com.example.app_user.ui.main.apply.volunteer

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel;
import com.example.app_user.connecter.Connecter
import com.example.app_user.model.VolunteerModel
import com.example.app_user.util.SingleLiveEvent
import com.example.app_user.util.getToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VolunteerViewModel(val app: Application) : AndroidViewModel(app) {

    val volunteerModel = MutableLiveData<ArrayList<VolunteerModel>>()
    val postId = MutableLiveData<String>()
    val gotoDetail = SingleLiveEvent<Any>()

    fun getVolunteer() {
        Connecter.api.getVolunteer(getToken(app.applicationContext))
            .enqueue(object : Callback<ArrayList<VolunteerModel>> {

                override fun onResponse(
                    call: Call<ArrayList<VolunteerModel>>,
                    response: Response<ArrayList<VolunteerModel>>
                ) {
                    volunteerModel.value = response.body()
                }

                override fun onFailure(call: Call<ArrayList<VolunteerModel>>, t: Throwable) {

                }

            })
    }

    fun gotoDetail(index: Int) {
        postId.value = volunteerModel.value!![index].post_id
        gotoDetail.call()
    }
}
