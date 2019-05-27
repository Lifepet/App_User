package com.example.app_user.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.app_user.databinding.ItemReportCommentBinding
import com.example.app_user.databinding.ItemReviewCommentBinding
import com.example.app_user.model.ReportCommentModel
import com.example.app_user.model.ReviewCommentModel
import com.example.app_user.ui.detailReport.DetailReportViewModel
import com.example.app_user.ui.detailReview.DetailReviewViewModel

class ReviewCommentAdapter(val viewModel: DetailReviewViewModel) :
    RecyclerView.Adapter<ReviewCommentAdapter.ViewHolder>() {

    var item = arrayListOf<ReviewCommentModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val binding = ItemReviewCommentBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind()
    }

    override fun getItemCount(): Int = item.size

    inner class ViewHolder(val binding: ItemReviewCommentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.reviewCommentModel = item[adapterPosition]
            binding.vm = viewModel
            binding.index = adapterPosition
        }
    }
}