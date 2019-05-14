package com.example.app_user.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.app_user.R
import com.example.app_user.databinding.ItemAdoptBinding
import com.example.app_user.databinding.ItemProtectBinding
import com.example.app_user.model.AdoptListModel
import com.example.app_user.model.ProtectModel
import com.example.app_user.ui.main.apply.protect.ProtectViewModel
import org.jetbrains.anko.find

class ProtectAdapter(val viewModel: ProtectViewModel) :
    RecyclerView.Adapter<ProtectAdapter.ViewHolder>() {

    var item = arrayListOf<ProtectModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val binding = ItemProtectBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind()
    }

    override fun getItemCount(): Int {
        return item.size
    }

    inner class ViewHolder(val binding: ItemProtectBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.protectModel = item[adapterPosition]
            binding.vm = viewModel
            binding.index = adapterPosition
        }

    }
}