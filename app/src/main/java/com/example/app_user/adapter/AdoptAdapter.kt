package com.example.app_user.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.app_user.R
import com.example.app_user.model.AdoptModel
import org.jetbrains.anko.find

class AdoptAdapter(internal var context: Context, internal var adoptModel: ArrayList<AdoptModel>) :
    RecyclerView.Adapter<AdoptAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_adopt, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind(adoptModel[i])
    }

    override fun getItemCount(): Int {
        return adoptModel.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text_Title = itemView.find<TextView>(R.id.text_title)
        val text_Content = itemView.find<TextView>(R.id.text_content)
        val text_Date = itemView.find<TextView>(R.id.text_date)
        val text_Writer = itemView.find<TextView>(R.id.text_writer)
        fun bind(adoptModel: AdoptModel) {
            text_Title.text = adoptModel.text_Title
            text_Content.text = adoptModel.text_Content
            text_Date.text = adoptModel.text_Date
            text_Writer.text = adoptModel.text_Writer
        }
    }
}