package com.example.app_user.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.app_user.R
import com.example.app_user.model.LostModel
import org.jetbrains.anko.find

class LostAdapter(internal var context: Context, internal var lostModel: ArrayList<LostModel>) :
    RecyclerView.Adapter<LostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_declaration, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind(lostModel[i])
    }

    override fun getItemCount(): Int {
        return lostModel.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text_Title = itemView.find<TextView>(R.id.text_title)
        val text_Gps=itemView.find<TextView>(R.id.text_gps)
        val text_Content = itemView.find<TextView>(R.id.text_content)
        val text_Date = itemView.find<TextView>(R.id.text_date)
        val text_Writer = itemView.find<TextView>(R.id.text_writer)
        fun bind(lostModel:LostModel) {
            text_Title.text = lostModel.text_Title
            text_Gps.text=lostModel.text_Gps
            text_Content.text = lostModel.text_Content
            text_Date.text = lostModel.text_Date
            text_Writer.text = lostModel.text_Writer
        }
    }
}