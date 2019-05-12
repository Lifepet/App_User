package com.example.app_user.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.app_user.R
import com.example.app_user.databinding.AdoptFragmentBinding
import com.example.app_user.databinding.ItemAdoptBinding
import com.example.app_user.model.AdoptListModel
import com.example.app_user.ui.main.adopt.AdoptViewModel
import org.jetbrains.anko.find

class AdoptAdapter(val viewModel: AdoptViewModel) :
    RecyclerView.Adapter<AdoptAdapter.ViewHolder>() {

    var item = arrayListOf<AdoptListModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val binding = ItemAdoptBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind()
    }

    override fun getItemCount(): Int = item.size

    inner class ViewHolder(val binding: ItemAdoptBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.adoptModel = item[adapterPosition]
            binding.vm = viewModel
            binding.index = adapterPosition
        }
    }
}