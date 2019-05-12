package com.example.app_user.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.app_user.R
import com.example.app_user.model.ProtectModel
import org.jetbrains.anko.find

class ProtectAdapter(internal var context: Context, internal var protectModel: ArrayList<ProtectModel>) :
    RecyclerView.Adapter<ProtectAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_apply, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind(protectModel[i])
    }

    override fun getItemCount(): Int {
        return protectModel.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text_Title = itemView.find<TextView>(R.id.text_title)
        val text_Info=itemView.find<TextView>(R.id.text_info)
        val text_Content = itemView.find<TextView>(R.id.text_content)
        val text_Date = itemView.find<TextView>(R.id.text_date)
        val text_Writer = itemView.find<TextView>(R.id.text_writer)
        fun bind(protectModel: ProtectModel) {
            text_Title.text = protectModel.text_Title
            text_Info.text=protectModel.text_Info
            text_Content.text = protectModel.text_Content
            text_Date.text = protectModel.text_Date
            text_Writer.text = protectModel.text_Writer
        }
    }
}