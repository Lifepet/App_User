package com.example.app_user.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.app_user.R
import com.example.app_user.model.AdoptModel
import com.example.app_user.model.ProtectModel
import com.example.app_user.model.VolunteerModel
import org.jetbrains.anko.find

class VolunteerAdapter(internal var context: Context, internal var volunteerModel: ArrayList<VolunteerModel>) :
    RecyclerView.Adapter<VolunteerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_apply, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind(volunteerModel[i])
    }

    override fun getItemCount(): Int {
        return volunteerModel.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text_Title = itemView.find<TextView>(R.id.text_title)
        val text_Info=itemView.find<TextView>(R.id.text_info)
        val text_Content = itemView.find<TextView>(R.id.text_content)
        val text_Date = itemView.find<TextView>(R.id.text_date)
        val text_Writer = itemView.find<TextView>(R.id.text_writer)
        fun bind(volunteerModel: VolunteerModel) {
            text_Title.text = volunteerModel.text_Title
            text_Info.text=volunteerModel.text_Info
            text_Content.text = volunteerModel.text_Content
            text_Date.text = volunteerModel.text_Date
            text_Writer.text = volunteerModel.text_Writer
        }
    }
}