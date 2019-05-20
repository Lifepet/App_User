package com.example.app_user.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.app_user.R
import com.example.app_user.databinding.ItemLostBinding
import com.example.app_user.databinding.ItemProtectBinding
import com.example.app_user.model.LostModel
import com.example.app_user.model.ProtectModel
import com.example.app_user.ui.main.declaration.lost.LostViewModel
import org.jetbrains.anko.find

class LostAdapter(val viewModel: LostViewModel) :
    RecyclerView.Adapter<LostAdapter.ViewHolder>() {

    var item = arrayListOf<LostModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val binding = ItemLostBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind()
    }

    override fun getItemCount(): Int {
        return item.size
    }

    inner class ViewHolder(val binding: ItemLostBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            binding.index = adapterPosition
            binding.vm = viewModel
            binding.lostModel = item[adapterPosition]
        }
    }
}