package com.example.app_user.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.app_user.databinding.ItemAdoptBinding
import com.example.app_user.databinding.ItemLostCommentBinding
import com.example.app_user.model.AdoptListModel
import com.example.app_user.model.LostCommentModel
import com.example.app_user.ui.detailLost.DetailLostViewModel

class LostCommentAdapter(val viewModel: DetailLostViewModel) :
    RecyclerView.Adapter<LostCommentAdapter.ViewHolder>() {

    var item = arrayListOf<LostCommentModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val binding = ItemLostCommentBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind()
    }

    override fun getItemCount(): Int = item.size

    inner class ViewHolder(val binding: ItemLostCommentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.lostCommentModel = item[adapterPosition]
            binding.vm = viewModel
            binding.index = adapterPosition
        }
    }
}