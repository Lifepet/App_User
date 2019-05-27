package com.example.app_user.ui.detailLost

import android.arch.lifecycle.LiveData
import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.app_user.adapter.AdoptCommentAdapter
import com.example.app_user.adapter.LostCommentAdapter
import com.example.app_user.adapter.VolunteerAdapter
import com.example.app_user.model.AdoptCommentModel
import com.example.app_user.model.LostCommentModel
import com.example.app_user.model.VolunteerModel

@BindingAdapter("lostCommentData")
fun RecyclerView.setLostComment(data: LiveData<ArrayList<LostCommentModel>>) {
    val lostCommentAdapter: LostCommentAdapter = adapter as LostCommentAdapter
    data.value?.let { lostCommentAdapter.item = it }
}