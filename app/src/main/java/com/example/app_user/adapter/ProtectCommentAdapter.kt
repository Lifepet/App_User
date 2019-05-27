package com.example.app_user.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.app_user.databinding.ItemLostCommentBinding
import com.example.app_user.databinding.ItemProtectCommentBinding
import com.example.app_user.model.LostCommentModel
import com.example.app_user.model.ProtectCommentModel
import com.example.app_user.model.ProtectModel
import com.example.app_user.ui.detailLost.DetailLostViewModel
import com.example.app_user.ui.detailProtect.DetailProtectViewModel
import com.example.app_user.ui.main.apply.protect.ProtectViewModel

class ProtectCommentAdapter(val viewModel: DetailProtectViewModel) :
    RecyclerView.Adapter<ProtectCommentAdapter.ViewHolder>() {

    var item = arrayListOf<ProtectCommentModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val binding = ItemProtectCommentBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind()
    }

    override fun getItemCount(): Int = item.size

    inner class ViewHolder(val binding: ItemProtectCommentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.protectCommentModel = item[adapterPosition]
            binding.vm = viewModel
            binding.index = adapterPosition
        }
    }
}