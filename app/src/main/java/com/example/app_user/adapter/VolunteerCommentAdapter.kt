package com.example.app_user.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.app_user.databinding.ItemReviewCommentBinding
import com.example.app_user.databinding.ItemVolunteerCommentBinding
import com.example.app_user.model.ReportCommentModel
import com.example.app_user.model.VolunteerCommentModel
import com.example.app_user.ui.detailReview.DetailReviewViewModel
import com.example.app_user.ui.detailVolunteer.DetailVolunteerViewModel

class VolunteerCommentAdapter(val viewModel: DetailVolunteerViewModel) :
    RecyclerView.Adapter<VolunteerCommentAdapter.ViewHolder>() {

    var item = arrayListOf<VolunteerCommentModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val binding = ItemVolunteerCommentBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind()
    }

    override fun getItemCount(): Int = item.size

    inner class ViewHolder(val binding: ItemVolunteerCommentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.volunteerCommentModel = item[adapterPosition]
            binding.vm = viewModel
            binding.index = adapterPosition
        }
    }
}