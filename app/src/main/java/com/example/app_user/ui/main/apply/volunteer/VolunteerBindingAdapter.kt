package com.example.app_user.ui.main.apply.volunteer

import android.arch.lifecycle.LiveData
import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.example.app_user.adapter.ProtectAdapter
import com.example.app_user.adapter.VolunteerAdapter
import com.example.app_user.model.ProtectModel
import com.example.app_user.model.VolunteerModel

@BindingAdapter("volunteerData")
fun RecyclerView.setVolunteerData(data: LiveData<ArrayList<VolunteerModel>>) {
    val volunteerAdapter: VolunteerAdapter = adapter as VolunteerAdapter
    data.value?.let { volunteerAdapter.item = it }
}