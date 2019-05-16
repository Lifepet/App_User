package com.example.app_user.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.app_user.R
import com.example.app_user.databinding.ItemApplyBinding
import com.example.app_user.databinding.ItemReviewBinding
import com.example.app_user.model.ReviewModel
import com.example.app_user.model.VolunteerModel
import com.example.app_user.ui.main.apply.volunteer.VolunteerViewModel
import org.jetbrains.anko.find

class VolunteerAdapter(val viewModel: VolunteerViewModel) :
    RecyclerView.Adapter<VolunteerAdapter.ViewHolder>() {
    var item = arrayListOf<VolunteerModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val binding = ItemApplyBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind()
    }

    override fun getItemCount(): Int {
        return item.size
    }

    inner class ViewHolder(val binding: ItemApplyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.index = adapterPosition
            binding.vm = viewModel
            binding.volunteerModel = item[adapterPosition]
        }
    }
}