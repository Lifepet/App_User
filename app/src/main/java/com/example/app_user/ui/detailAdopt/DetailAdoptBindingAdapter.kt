package com.example.app_user.ui.detailAdopt

import android.arch.lifecycle.LiveData
import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.app_user.adapter.AdoptCommentAdapter
import com.example.app_user.adapter.VolunteerAdapter
import com.example.app_user.model.AdoptCommentModel
import com.example.app_user.model.VolunteerModel

@BindingAdapter("image","errorImage")
    fun setImageUrl(view:ImageView,uri:String?,error:Drawable){
    Glide.with(view.context).load(uri).apply(RequestOptions().override(150, 150)).into(view)
}
@BindingAdapter("adoptCommentData")
fun RecyclerView.setadoptCommentDia(data: LiveData<ArrayList<AdoptCommentModel>>) {
    val adoptCommentAdapter: AdoptCommentAdapter = adapter as AdoptCommentAdapter
    data.value?.let { adoptCommentAdapter.item = it }
}