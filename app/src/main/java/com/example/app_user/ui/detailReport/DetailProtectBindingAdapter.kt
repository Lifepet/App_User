package com.example.app_user.ui.detailReport

import android.arch.lifecycle.LiveData
import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.app_user.adapter.LostCommentAdapter
import com.example.app_user.adapter.ProtectCommentAdapter
import com.example.app_user.adapter.ReportCommentAdapter
import com.example.app_user.model.LostCommentModel
import com.example.app_user.model.ProtectCommentModel
import com.example.app_user.model.ReportCommentModel

@BindingAdapter("image","errorImage")
fun setImageUrl(view: ImageView, uri:String?, error: Drawable){
    Glide.with(view.context).load(uri).apply(RequestOptions()).into(view)
}

@BindingAdapter("reportData")
fun RecyclerView.setReportData(data: LiveData<ArrayList<ReportCommentModel>>) {
    val reportCommentAdapter: ReportCommentAdapter = adapter as ReportCommentAdapter
    data.value?.let { reportCommentAdapter.item = it }
}