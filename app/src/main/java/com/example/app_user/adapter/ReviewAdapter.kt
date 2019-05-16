package com.example.app_user.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.app_user.R
import com.example.app_user.databinding.ItemAdoptBinding
import com.example.app_user.databinding.ItemReviewBinding
import com.example.app_user.model.AdoptListModel
import com.example.app_user.model.ReviewModel
import com.example.app_user.ui.main.review.ReviewViewModel
import org.jetbrains.anko.find

class ReviewAdapter(val viewModel: ReviewViewModel) :
    RecyclerView.Adapter<ReviewAdapter.ViewHolder>() {
    var item = arrayListOf<ReviewModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val binding = ItemReviewBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind()
    }

    override fun getItemCount(): Int {
        return item.size
    }

    inner class ViewHolder(val binding: ItemReviewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.index = adapterPosition
            binding.reviewModel = item[adapterPosition]
            binding.vm = viewModel
        }
    }
}