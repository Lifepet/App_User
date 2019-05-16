package com.example.app_user.ui.main.review

import android.arch.lifecycle.LiveData
import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.app_user.adapter.AdoptAdapter
import com.example.app_user.adapter.ReviewAdapter
import com.example.app_user.model.AdoptListModel
import com.example.app_user.model.ReviewModel

@BindingAdapter("reviewData")
fun RecyclerView.setAdoptData(data: LiveData<ArrayList<ReviewModel>>) {
    val reviewAdapter: ReviewAdapter = adapter as ReviewAdapter
    data.value?.let { reviewAdapter.item = it }
}

@BindingAdapter("imageUrl", "error")
fun setImageUrl(view: ImageView, url: String, error: Drawable) {
    Glide.with(view.context).load(url).apply(RequestOptions().override(150, 150)).into(view)
}