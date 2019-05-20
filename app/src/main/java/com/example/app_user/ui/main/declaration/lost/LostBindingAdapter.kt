package com.example.app_user.ui.main.declaration.lost

import android.arch.lifecycle.LiveData
import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.app_user.adapter.LostAdapter
import com.example.app_user.adapter.ProtectAdapter
import com.example.app_user.model.LostModel
import com.example.app_user.model.ProtectModel

@BindingAdapter("lostData")
fun RecyclerView.setLostData(data: LiveData<ArrayList<LostModel>>) {
    val lostAdapter: LostAdapter = adapter as LostAdapter
    data.value?.let { lostAdapter.item = it }
}
@BindingAdapter("imageUrl", "error")
fun setImageUrl(view: ImageView, url: String, error: Drawable) {
    Glide.with(view.context).load(url).apply(RequestOptions().override(150, 150)).into(view)
}