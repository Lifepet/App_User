package com.example.app_user.ui.detailReview

import android.arch.lifecycle.LiveData
import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.app_user.adapter.ProtectCommentAdapter
import com.example.app_user.adapter.ReviewCommentAdapter
import com.example.app_user.model.ProtectCommentModel
import com.example.app_user.model.ReviewCommentModel

@BindingAdapter("imageUrl", "error")
fun setImageUrl(view: ImageView, uri: String?, error: Drawable) {
    Glide.with(view.context).load(uri).apply(RequestOptions()).into(view)
}

@BindingAdapter("reviewData")
fun RecyclerView.setReviewData(data: LiveData<ArrayList<ReviewCommentModel>>) {
    val reviewCommentAdapter: ReviewCommentAdapter = adapter as ReviewCommentAdapter
    data.value?.let { reviewCommentAdapter.item = it }
}