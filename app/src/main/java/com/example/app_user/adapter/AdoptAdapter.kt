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
import com.example.app_user.model.AdoptListModel
import com.example.app_user.ui.main.adopt.AdoptViewModel
import org.jetbrains.anko.find

class AdoptAdapter(val viewModel: AdoptViewModel) :
    RecyclerView.Adapter<AdoptAdapter.ViewHolder>() {
    var item = arrayListOf<AdoptListModel>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val binding = AdoptFragmentBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind(item[i])
    }

    override fun getItemCount(): Int = item.size

    inner class ViewHolder(val binding: AdoptFragmentBinding) : RecyclerView.ViewHolder(binding.root) {
        val textTitle = itemView.find<TextView>(R.id.text_title)
        val textContent = itemView.find<TextView>(R.id.text_content)
        val textDate = itemView.find<TextView>(R.id.text_date)
        val textWriter = itemView.find<TextView>(R.id.text_writer)
        val textImage = itemView.find<ImageView>(R.id.ic_adopt)
        fun bind(adoptModel: AdoptListModel) {
            textTitle.text = adoptModel.title
            textContent.text = adoptModel.content
            textDate.text = adoptModel.creationDate
            textWriter.text = adoptModel.postId
            if (adoptModel.image.isNotEmpty()) {
                Glide.with(itemView).load(adoptModel.image).apply(RequestOptions().override(150, 150))
                    .into(textImage)
            }
        }
    }
}