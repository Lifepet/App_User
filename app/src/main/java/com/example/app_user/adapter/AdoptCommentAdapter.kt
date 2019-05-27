package com.example.app_user.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.app_user.databinding.ItemAdoptBinding
import com.example.app_user.databinding.ItemAdoptCommentBinding
import com.example.app_user.databinding.ItemLostBinding
import com.example.app_user.model.AdoptCommentModel
import com.example.app_user.model.AdoptListModel
import com.example.app_user.ui.detailAdopt.DetailAdoptViewModel

class AdoptCommentAdapter(val viewModel: DetailAdoptViewModel) :
    RecyclerView.Adapter<AdoptCommentAdapter.ViewHolder>() {

    var item = arrayListOf<AdoptCommentModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ViewHolder {
        val binding = ItemAdoptCommentBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)

    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind()
    }

    inner class ViewHolder(val binding: ItemAdoptCommentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.adoptCommentModel = item[adapterPosition]
            binding.index = adapterPosition
            binding.vm = viewModel
        }
    }
}