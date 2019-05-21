package com.example.app_user.ui.applyVolunteer

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.example.app_user.util.SingleLiveEvent

class ApplyVolunteerViewModel (val app:Application):AndroidViewModel(app){
    val volunteerTime = MutableLiveData<String>()
    val protectDate = MutableLiveData<String>()
    val protectId = MutableLiveData<String>()
    val protectContent = MutableLiveData<String>()
    val postId = MutableLiveData<String>()
    val volunteerApply = SingleLiveEvent<Any>()
}