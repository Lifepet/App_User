package com.example.app_user.ui.detailVolunteer

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.example.app_user.connecter.Connecter
import com.example.app_user.model.AdoptCommentModel
import com.example.app_user.model.VolunteerCommentModel
import com.example.app_user.model.VolunteerModel
import com.example.app_user.util.SingleLiveEvent
import com.example.app_user.util.getToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailVolunteerViewModel(val app: Application) : AndroidViewModel(app) {

    val volunteerModel = MutableLiveData<VolunteerModel>()
    val postId = MutableLiveData<String>()
    val gotoApply = SingleLiveEvent<Any>()
    val volunteerCommentModel = MutableLiveData<ArrayList<VolunteerCommentModel>>()

    fun getVolunteerDetail() {
        Connecter.api.getVolunteerDetail(getToken(app.applicationContext), postId.value!!)
            .enqueue(object : Callback<VolunteerModel> {

                override fun onResponse(call: Call<VolunteerModel>, response: Response<VolunteerModel>) {
                    volunteerModel.value = response.body()
                }

                override fun onFailure(call: Call<VolunteerModel>, t: Throwable) {

                }

            })
    }

    fun gotoApply() {
        gotoApply.call()
    }

    val gotoComment = SingleLiveEvent<Any>()

    fun gotoComment() {
        gotoComment.call()
    }

    fun getVolunteerComment() {
        Connecter.api.getVolunteerComment(getToken(app.applicationContext), postId.value!!)
            .enqueue(object : Callback<ArrayList<VolunteerCommentModel>> {

                override fun onResponse(
                    call: Call<ArrayList<VolunteerCommentModel>>,
                    response: Response<ArrayList<VolunteerCommentModel>>
                ) {
                    volunteerCommentModel.value = response.body()
                }

                override fun onFailure(call: Call<ArrayList<VolunteerCommentModel>>, t: Throwable) {

                }
            })
    }
}