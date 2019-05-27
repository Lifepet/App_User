package com.example.app_user.ui.detailVolunteer

import android.arch.lifecycle.LiveData
import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.app_user.adapter.ProtectCommentAdapter
import com.example.app_user.adapter.ReviewCommentAdapter
import com.example.app_user.adapter.VolunteerCommentAdapter
import com.example.app_user.model.ProtectCommentModel
import com.example.app_user.model.ReviewCommentModel
import com.example.app_user.model.VolunteerCommentModel

@BindingAdapter("volunteerData")
fun RecyclerView.setVolunteerData(data: LiveData<ArrayList<VolunteerCommentModel>>) {
    val volunteerCommentAdapter: VolunteerCommentAdapter = adapter as VolunteerCommentAdapter
    data.value?.let { volunteerCommentAdapter.item = it }
}