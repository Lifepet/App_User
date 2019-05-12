package com.example.app_user.ui.main.adopt

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.app_user.adapter.AdoptAdapter
import com.example.app_user.model.AdoptListModel

@BindingAdapter("adoptData")
fun RecyclerView.setAdoptData(data: LiveData<ArrayList<AdoptListModel>>) {
    val adoptAdapter: AdoptAdapter = adapter as AdoptAdapter
    data.value?.let { adoptAdapter.item = it }
}

@BindingAdapter("imageUrl", "error")
fun setImageUrl(view: ImageView, url: String, error: Drawable) {
    Glide.with(view.context).load(url).apply(RequestOptions().override(150, 150)).into(view)
}