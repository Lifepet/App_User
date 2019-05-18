package com.example.app_user.ui.main.declaration.report

import android.arch.lifecycle.LiveData
import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.app_user.adapter.ProtectAdapter
import com.example.app_user.adapter.ReportAdapter
import com.example.app_user.model.ProtectModel
import com.example.app_user.model.ReportModel

@BindingAdapter("reportData")
fun RecyclerView.setReportData(data: LiveData<ArrayList<ReportModel>>) {
    val ReportAdapter: ReportAdapter = adapter as ReportAdapter
    data.value?.let { ReportAdapter.item = it }
}

@BindingAdapter("imageUrl", "error")
fun setImageUrl(view: ImageView, url: String, error: Drawable) {
    Glide.with(view.context).load(url).apply(RequestOptions().override(150, 150)).into(view)
}